/*
 * UserRegistrationAction.java
 *
 * Created on April 18, 2006, 11:24 PM
 */

package net.shellfspace.struts.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.UserSessionBean;
import net.shellfspace.struts.form.UserRegistrationForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 * @version
 */

public class UserRegistrationAction extends Action {
    
    ConnectionPool connPool;
    Connection theCon;
    private String forwardString;
    
    public UserRegistrationAction() {
        forwardString = "";
        try {
            this.connPool = new ConnectionPool();
        } catch ( SQLException sqlEx ) {
            sqlEx.printStackTrace( System.out );
            // println( "SQLException in constructor for UserRegistrationAction" );
            // println( sqlEx.getMessage() );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            // println( "Exception in constructor for UserRegistrationAction" );
            // println( e.getMessage() );
        } // end try/catch
    } // end constructor
    
   
    protected boolean fieldsAreBad( UserRegistrationForm uRForm )
    throws IOException {
        boolean fieldsAreBad = false; // assume fields are good
    	// println( connPool.toString() );
                                
        // get info from request
        String userName        = uRForm.getUserName();
        String password        = uRForm.getPassword();
        String confirmPass     = uRForm.getConfirmPassword();
        String emailAddr       = uRForm.getEmailAddress();
        String operatingSystem = uRForm.getOSName();
        String browserName     = uRForm.getBrowserName();
        String osVersion       = uRForm.getOSVersionNumber();
        String browserNumber   = uRForm.getBrowserVersionNumber(); 
        
        int userCount = 0;
        boolean emptySet = true;
        boolean userAlreadyExists       = false;
        boolean passWordsDifferent      = false;
        boolean osVersionNotValid       = false;
        boolean browserVesionNotValid   = false;
        boolean passwordLengthWrong     = false;
        boolean userNameLengthWrong     = false;
        float osFloat = 0, browserFloat = 0;
        
        StringBuffer cannotContinue = new StringBuffer();
        // make sure same password was entered
        if ( !password.equals( confirmPass ) ) {
            cannotContinue.append( 
            	"Password error: You did not type the same password twice<br />" 
            );
            passWordsDifferent = true;   
        }
        
        if ( ( 6 > password.length() ) || ( 12 < password.length() )  ) {
            cannotContinue.append( "The password must be between 6 and 12 characters. " +
                "You entered a password of " + password.length() + " characters.<br />" 
            );
            passwordLengthWrong = true;
        }
                
        if ( ( 6 > userName.length() ) || ( 12 < userName.length() )  ) {
            cannotContinue.append( "The user name must be between 6 and 12 characters. " +
                "You entered a user name of " + userName.length() + " characters.<br />" 
            );
            userNameLengthWrong = true;
        }
        
        // make sure osVersion and browserNumber are floats
        try {
            osFloat = Float.parseFloat( osVersion );
        } catch ( NumberFormatException NumFormatEx ) {
            cannotContinue.append( "The number you entered for the version of " +
                "your OS (" + osVersion + ") is not a valid floating-point number<br />" 
            );
            osVersionNotValid = true;
        } 
        
        try {
            browserFloat = Float.parseFloat( browserNumber );
        } catch ( NumberFormatException NumFormatEx ) {
            cannotContinue.append( "The number you entered for the version of " +
                "your browser (" + browserNumber + 
                ") is not a valid floating-point number<br />" 
            );
            browserVesionNotValid = true;  
        } 
        
        try {
            theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); // got error here
            theStatement.clearBatch();
            
            ResultSet rSet = theStatement.executeQuery( 
                "select user_id_name from user_entry_current " +
                "where user_id_name like '" + userName + "'"
            );
            
            while ( rSet.next() ) {
                String resultName = rSet.getString( 1 );
                if ( resultName.length() != 0 ) { 
                    userAlreadyExists = true;
                }
            } // end while ( rSet.next() )
        
            if ( userAlreadyExists ) {
                cannotContinue.append( "The user name you selected (" + userName + 
                    ") is already in use. Please select another name<br />" 
                );
            }
            
            if ( userAlreadyExists || passWordsDifferent || osVersionNotValid 
                 || browserVesionNotValid || passwordLengthWrong 
                 || userNameLengthWrong ) {
                /*
                println( "Your request could not be processed for the " +
                    "following reasons:\n" +
                    cannotContinue + "\n"
                );
                */
                uRForm.setWarning( cannotContinue.toString() );
                fieldsAreBad = true;
                  
            } // end if ( userAlreadyExists || passWordsDifferent || osVersionNotValid )/else
            
            theStatement.close();
            connPool.free( theCon );
        } catch ( SQLException SQLEx ) {
            // println( "SQLEXception occurred: \n" + SQLEx.getMessage() );
            /*
            println( "here is the statement: insert into user_entry_current " +
                "(user_counter, profile_number, user_id_name, password, email_address," +
                " date_joined) " + "values ('" + userCount + "', '1', '" +
                userName + "', '" + password + "', '" + emailAddr +
                "', '" + getDate() + "')"    
            );
            */
            SQLEx.printStackTrace();
            uRForm.setWarning( "There seems to be a database issue. Please try again" );
            fieldsAreBad = true;
        } // end try/catch
        
        return fieldsAreBad;
                        
    } // end method fieldsAreBad
    
    /* ====================================================================== */
	
    protected void processRequest( UserRegistrationForm uRForm, HttpServletRequest request )
    throws IOException {
    	// println( connPool.toString() );
        // get the httpSession and add info to the userSessionBean
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );        
                
        // get info from request
        String userName        = uRForm.getUserName();
        String password        = uRForm.getPassword();
        String confirmPass     = uRForm.getConfirmPassword();
        String emailAddr       = uRForm.getEmailAddress();
        String operatingSystem = uRForm.getOSName();
        String browserName     = uRForm.getBrowserName();
        String osVersion       = uRForm.getOSVersionNumber();
        String browserNumber   = uRForm.getBrowserVersionNumber(); 
        
        int userCount = 0;
        boolean emptySet = true;
        boolean userAlreadyExists       = false;
        boolean passWordsDifferent      = false;
        boolean osVersionNotValid       = false;
        boolean browserVesionNotValid   = false;
        boolean passwordLengthWrong     = false;
        boolean userNameLengthWrong     = false;
        float osFloat = 0, browserFloat = 0;
        
        try {
            theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); // got error here
            theStatement.clearBatch();
            
            theStatement.executeUpdate( "insert into new_user_counter values ( 0 )" );
            theStatement.clearBatch();
            ResultSet rSet = theStatement.executeQuery( 
                "select MAX(new_user_count) from new_user_counter"
            );
            while ( rSet.next() ) { 
                userCount = rSet.getInt( 1 ); 
            } // while ( rSet.next() )
            theStatement.clearBatch();
                        
            theStatement.executeUpdate( "insert into user_entry_current " +
                "(user_counter, profile_number, user_id_name, password, " +
                "email_address, date_joined) " +
                "values ('" + userCount + "', '1', '" +
                userName + "', '" + password + "', '" + emailAddr +
                "', '" + getDate() + "')"
            );   
            
            theStatement.clearBatch();
            theStatement.executeUpdate( "insert into user_entry_archive " +
                "(user_counter, user_profile_number, operating_system, " +
                " browser, kernel_version, browser_version) " + 
                "values ('" + userCount + "', '1', '" +
                operatingSystem +  "', '" +
                browserName + "', '" + osVersion + "', '" + browserNumber + "')"
            );
            
            // populate UserSessionBean object
            // println( "Here is uRForm.getUserName(): " + uRForm.getUserName() );
            userSessBean.setSessionUserName( uRForm.getUserName() );
            userSessBean.setSessionUserNumber( userCount );
            userSessBean.setSessionUserProfileNum( 1 );
            userSessBean.setSessionUserEmail( uRForm.getEmailAddress() );
            Float wtf = new Float( uRForm.getBrowserVersionNumber() ); // browserNumber );
            userSessBean.setSessionBrowserNum( wtf.floatValue() );
            userSessBean.setSessionBrowser( uRForm.getBrowserName() );
            userSessBean.setSessionOS( uRForm.getOSName() );
            Float thisIsStupid = new Float( uRForm.getOSVersionNumber() ); // osVersion );
            userSessBean.setSessionOSNum( thisIsStupid.floatValue() );
            // put the updated UserSessionBean back in the session
            theSession.setAttribute( "userSessionBean", userSessBean ); 
            
            theStatement.close();
            connPool.free( theCon );
        } catch ( SQLException SQLEx ) {
            // println( "SQLEXception occurred: \n" + SQLEx.getMessage() );
            /*
            println( "here is the statement: insert into user_entry_current " +
                "(user_counter, profile_number, user_id_name, password, email_address," +
                " date_joined) " + "values ('" + userCount + "', '1', '" +
                userName + "', '" + password + "', '" + emailAddr +
                "', '" + getDate() + "')"    
            )*/
            SQLEx.printStackTrace();
        } // end try/catch
                        
    } // end method processRequest - line 380
    
    private String getDate() {
        GregorianCalendar theCal = new GregorianCalendar();
        return ( theCal.get( Calendar.YEAR ) + "-" +
            ( theCal.get( Calendar.MONTH ) + 1 ) + "-" +
            theCal.get( Calendar.DATE )
        );
    } // end method getDate

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
    public synchronized ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response ) {
        UserRegistrationForm uRForm = ( UserRegistrationForm ) form;
        // TODO Auto-generated method stub
        forwardString = "";
        try {
            if ( this.fieldsAreBad( uRForm ) ) {
                forwardString = "failure";
            } else {
                this.processRequest( uRForm, request );
                forwardString = "success";
            } // if ( this.fieldsAreBad( uRForm ) )
        } catch ( IOException ioEx ) {
            // println( "IOException calling processRequest" );
            ioEx.printStackTrace( System.out );
            forwardString = "failure";
        } // end try/catch
                
        request.setAttribute( "userName", uRForm.getUserName() );
        request.setAttribute( "browserName", uRForm.getBrowserName() );
        request.setAttribute( "browserVersionNumber", uRForm.getBrowserVersionNumber() );
        request.setAttribute( "OSName", uRForm.getOSName() );
        request.setAttribute( "OSVersionNumber", uRForm.getOSVersionNumber() );	
        request.setAttribute( "emailAddress", uRForm.getEmailAddress() );        
        
        return mapping.findForward( forwardString );
        
    } // end method execute

} // end class net.shellfspace.struts.action.UserRegistrationAction - line 298 
