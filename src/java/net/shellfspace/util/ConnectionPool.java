/*
 * ConnectionPool.java
 *
 * Created on April 18, 2006, 10:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.shellfspace.util;

import java.io.InputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.util.Vector;

/** A class for preallocating, recycling, and managing
 *  JDBC connections.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2000 Marty Hall; may be freely used or adapted.
 */

public class ConnectionPool implements Runnable {
    private String driver, url, username, password;
    private int maxConnections;
    private int initialConnections;
    private boolean waitIfBusy;
    private Vector availableConnections, busyConnections;
    private boolean connectionPending = false;
    Properties myProp = new Properties();
    
    public ConnectionPool( 
            String driver, 
            String url, 
            String username, 
            String password,
            int initialConnections, 
            int maxConnections, 
            boolean waitIfBusy )
    throws SQLException {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;
        this.waitIfBusy = waitIfBusy;
        if ( initialConnections > maxConnections ) {
            initialConnections = maxConnections;
        }
        availableConnections = new Vector( initialConnections );
        busyConnections = new Vector();
        for ( int i = 0; i < initialConnections; i++ ) {
            availableConnections.addElement( makeNewConnection() );
        }
    } // end method ConnectionPool constructor with args
    
    public ConnectionPool() throws SQLException {
        
        this.startProp();
       
        this.driver   = myProp.getProperty( "db.driver" );
        this.url      = myProp.getProperty( "db.url" );
        this.username = myProp.getProperty( "db.username" ); 
        this.password = myProp.getProperty( "db.password" ); 
        this.initialConnections = 10;
        this.maxConnections     = 50;
        this.waitIfBusy = true;
        if ( initialConnections > maxConnections ) { 
            initialConnections = maxConnections; 
        }
        availableConnections = new Vector( initialConnections );
        busyConnections = new Vector();
        for ( int i = 0; i < initialConnections; i++ ) {
            availableConnections.addElement( makeNewConnection() );
        }
    } // end method ConnectionPool no-arg constructor
    
    public synchronized Connection getConnection() throws SQLException {
        if ( !availableConnections.isEmpty() ) {
            Connection existingConnection = 
                    ( Connection ) availableConnections.lastElement();
            int lastIndex = availableConnections.size() - 1;
            availableConnections.removeElementAt( lastIndex );
            // If connection on available list is closed (e.g.,
            // it timed out), then remove it from available list
            // and repeat the process of obtaining a connection.
            // Also wake up threads that were waiting for a
            // connection because maxConnection limit was reached.
            if ( existingConnection.isClosed() ) {
                notifyAll(); // Freed up a spot for anybody waiting
                return( getConnection() );
            } else {
                busyConnections.addElement( existingConnection );
                return( existingConnection );
            }
        } else {
            // Three possible cases:
            // 1) You haven't reached maxConnections limit. So
            //    establish one in background if there isn't
            //    already one pending, then wait for
            //    next available connection (whether or not
            //    it was newly established one).
            // 2) You reached maxConnections limit and waitIfBusy
            //    flag is false. Throw SQLException in such a case.
            // 3) You reached maxConnections limit and waitIfBusy
            //    flag is true. Then do the same thing as in second
            //    part of step 1: wait for next available connection.
            if ( ( totalConnections() < maxConnections ) && !connectionPending ) {
                makeBackgroundConnection();
            } else if ( !waitIfBusy ) {
                throw new SQLException( "Connection limit reached" );
            }
            // Wait for either a new connection to be established
            // (if you called makeBackgroundConnection) or for
            // an existing connection to be freed up.
            try { 
            	wait(); 
            }  catch ( InterruptedException ie ) {}
            // Someone freed up a connection, so try again.
            return( getConnection() );
        } // end if/else ( !availableConnections.isEmpty() )
    } // end method getConnection
    
    // You can't just make a new connection in the foreground
    // when none are available, since this can take several
    // seconds with a slow network connection. Instead,
    // start a thread that establishes a new connection,
    // then wait. You get woken up either when the new connection
    // is established or if someone finishes with an existing
    // connection.
    private void makeBackgroundConnection() {
        connectionPending = true;
        try {
            Thread connectThread = new Thread( this );
            connectThread.start();
        } catch ( OutOfMemoryError oome ) { } // Give up on new connection
    } // end method makeBackgroundConnection
    
    public void run() {
    	try {
            Connection connection = makeNewConnection();
            synchronized( this ) {
                availableConnections.addElement( connection );
                connectionPending = false;
                notifyAll();
            }
    	} catch ( Exception e ) { // SQLException or OutOfMemory
            // Give up on new connection and wait for existing one
            // to	 free up.
    	} // end try/catch
    } // end method run

    // This explicitly makes a new connection. Called in
    // the foreground when initializing the ConnectionPool,
    // and called in the background when running.
  
    private Connection makeNewConnection() throws SQLException {
    	try {
            // Load database driver if not already loaded
            Class.forName( driver );

            // Establish network connection to database
            Connection connection = 
                DriverManager.getConnection( url, username, password 
            );
            return( connection );
    	} catch ( ClassNotFoundException cnfe ) {
            // Simplify try/catch blocks of people using this by
            // 	throwing only one exception type.
            throw new SQLException( "Can't find class for driver: " + driver );
    	}
    } // end method makeNewConnection

    public synchronized void free( Connection connection ) {
    	busyConnections.removeElement( connection );
    	availableConnections.addElement( connection );
    	// Wake up threads that are waiting for a connection
    	notifyAll(); 
    } // end method free
    
    public synchronized int totalConnections() {
    	return( availableConnections.size() + busyConnections.size() );
    }

    /** Close all the connections. Use with caution:
     *  be sure no connections are in use before
     *  calling. Note that you are not <I>required</I> to
     *  call this when done with a ConnectionPool, since
     *  connections are guaranteed to be closed when
     *  garbage collected. But this method gives more control
     *  regarding when the connections are closed.
     */
    public synchronized void closeAllConnections() {
    	closeConnections( availableConnections );
    	availableConnections = new Vector();
    	closeConnections( busyConnections );
    	busyConnections = new Vector();
    } // end method closwAllConnections

    private void closeConnections( Vector connections ) {
        try {
            for ( int i = 0; i < connections.size(); i++ ) {
                Connection connection = ( Connection ) connections.elementAt( i );
                if ( !connection.isClosed() ) {
                    connection.close();
                }
            } // for ( int i = 0; i < connections.size(); i++ )
    	} catch ( SQLException sqle ) {
            // Ignore errors; garbage collect anyhow
    	}	
    } // end method closeConnections
  
    public synchronized String toString() {
    	String info = 
            "ConnectionPool(" + url + "," + username + ")" +
            ", available=" + availableConnections.size() +
            ", busy=" + busyConnections.size() +
            ", max=" + maxConnections +
            "\nHere is how we made connections: " +
            "( " + url + ", " + username + ", " + password + " )"
    	;
    	return( info );
    } // end methodtoString
    
    public void startProp() {
        
        try {
            InputStream is = getClass().getResourceAsStream( 
                "/dbconnection.properties" 
            );
            myProp.load( is ); // this may throw IOException
            
        } catch ( IOException ioe ) {
            // println( "Properties loading failed in AppConfig" );
            ioe.printStackTrace( System.out ); 
        } catch ( NullPointerException npEx ) {
            // println( "NullPointerException" );
            // println( "Here is the message: " +  npEx.getMessage() );
            npEx.printStackTrace( System.out );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
        } // end try/catch
    } // end method startProp
    
} // end class net.shellfspace.util.ConnectionPool
