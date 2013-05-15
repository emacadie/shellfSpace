/*
 * UpdateProfileAction.java
 *
 * Created on August 3, 2006, 11:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
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
import net.shellfspace.struts.form.UpdateProfileForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 */
public class UpdateProfileAction extends Action  {
    
    ConnectionPool connPool;
    Connection theCon;
    private String forwardString;
    
    public UpdateProfileAction() {
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
    
    protected boolean fieldsAreBad( UpdateProfileForm uPForm )
    throws IOException {
        boolean fieldsAreBad = false; // assume fields are good
        String operatingSystem = uPForm.getOSName();
        String browserName     = uPForm.getBrowserName();
        String osVersion       = uPForm.getOSVersionNumber();
        String browserNumber   = uPForm.getBrowserVersionNumber();  
        
        int userProfile                 = 0;
        boolean osVersionNotValid       = false;
        boolean browserVesionNotValid   = false;
        float osFloat = 0, browserFloat = 0;
        
        StringBuffer cannotContinue = new StringBuffer();
        
        try {
            osFloat = Float.parseFloat( osVersion );
        } catch ( NumberFormatException NumFormatEx ) {
            cannotContinue.append( 
                "The number you entered for the version of your OS (" + 
                osVersion + ") is not a valid floating-point number<br />" 
            );
            osVersionNotValid = true;
        }
        try {
            browserFloat = Float.parseFloat( browserNumber );
        } catch ( NumberFormatException NumFormatEx ) {
            cannotContinue.append( 
                "The number you entered for the version of your browser (" + 
                browserNumber + ") is not a valid floating-point number<br />" 
            );
            browserVesionNotValid = true;  
        } 
            
        if ( osVersionNotValid || browserVesionNotValid ) {
            uPForm.setWarning( cannotContinue.toString() );
            fieldsAreBad = true;
        } // if ( osVersionNotValid || browserVesionNotValid )
                
        return fieldsAreBad;
    } // end method fieldsAreBad
    
    protected void processRequest( 
            UpdateProfileForm uPForm, HttpServletRequest request )
    throws IOException {
        
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessionBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );
                        
        String operatingSystem = uPForm.getOSName();
        String browserName     = uPForm.getBrowserName();
        String osVersion       = uPForm.getOSVersionNumber();
        String browserNumber   = uPForm.getBrowserVersionNumber();  
        
        int userProfile = 0, updateCurrent = 0, updateArchive = 0, updateResult = 0;
        boolean osVersionNotValid       = false;
        boolean browserVesionNotValid   = false;
        float osFloat = 0, browserFloat = 0;
        
        try {

            theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement();
            
            theStatement.clearBatch();
            updateResult = theStatement.executeUpdate( 
                "update user_entry_current set profile_number = " + 
                 ( userSessionBean.getSessionUserProfileNum() + 1 ) + 
                " where  ( user_id_name = '" +
                userSessionBean.getSessionUserName() + 
                "' ) and " + "( user_counter = " + 
                userSessionBean.getSessionUserNumber() + " )"
            );

            if ( updateResult == 0 ) {
                /* println( "Your update failed. Here is the statement:\n" +
                    "update user_entry_current set profile_number=" +  
                    ( userSessionBean.getSessionUserProfileNum() + 1 ) + 
                    " where  (user_id_name='" +
                    userSessionBean.getSessionUserName() + 
                    "') and " + "(user_counter=" + 
                    userSessionBean.getSessionUserNumber() + ")"
                ); */
            } else {
                /* println( "DEBUG: Here is the statement:\n" +
                    "update user_entry_current set profile_number = " + 
                    ( userSessionBean.getSessionUserProfileNum() + 1 ) + 
                    " where  ( user_id_name = '" +
                    userSessionBean.getSessionUserName() + 
                    "' ) and " + "( user_counter = " + 
                    userSessionBean.getSessionUserNumber() + " )"
                ); */
                userProfile++;
            } // if ( updateResult == 0 )

            theStatement.clearBatch();
            /* println( "DEBUG: Here is the statement:\n" +
                "insert into user_entry_archive (user_counter, " +
                "user_profile_number, operating_system, " +
                " browser, kernel_version, browser_version) " + "values ('" + 
                userSessionBean.getSessionUserNumber() + "', '" + 
                ( userSessionBean.getSessionUserProfileNum() + 1 ) + 
                "', '" + operatingSystem + " ', '" + browserName + 
                "', '" + osVersion + "', '" + browserNumber + "')"
            ); */
            updateResult = theStatement.executeUpdate( 
                "insert into user_entry_archive (user_counter, " +
                "user_profile_number, operating_system, " +
                " browser, kernel_version, browser_version) " + "values ('" + 
                userSessionBean.getSessionUserNumber() + "', '" + 
                ( userSessionBean.getSessionUserProfileNum() + 1 ) + 
                "', '" + operatingSystem + " ', '" + browserName + 
                "', '" + osVersion + "', '" + browserNumber + "')"
            );
            if ( updateResult == 0 ) {
                /* println( 
                "Your insert failed. Here is the statement:\n" +
                "insert into user_entry_archive (user_counter, " +
                "user_profile_number, operating_system, " +
                " browser, kernel_version, browser_version) " + "values ('" + 
                userSessionBean.getSessionUserNumber() + 
                "', " + ( userSessionBean.getSessionUserProfileNum() + 1 ) +
                "', " + operatingSystem + " ', '" + 
                browserName + "', '" + osVersion + "', '" + 
                browserNumber + "')"
                ); */
            } // if ( updateResult == 0 )

            // here: osVersion browserNumber 
            // inDB: kernel_version, browser_version

            Float osFloat02 = new Float( osVersion );
            // theSession.setAttribute( "sessionOSNum", osFloat02 );
            Float browserFloat02 = new Float( browserNumber );
            // theSession.setAttribute( "sessionBrowserNum", browserFloat02 );
            // theSession.setAttribute( "sessionBrowser", browserName );
            StringBuffer theOSForSession = new StringBuffer();
            theOSForSession.append( operatingSystem );

            // increment user profile number in session
            Integer userProfileInteger = new Integer( userProfile );
            // theSession.setAttribute( "sessionUserProfileNum", userProfileInteger );
            // set the variables in the UserSessionBean
            userSessionBean.setSessionOS( uPForm.getOSName() );
            userSessionBean.setSessionOSNum( osFloat02.floatValue() ); 
            // uPForm.getOSVersionNumber() );
            userSessionBean.setSessionBrowser( uPForm.getBrowserName() );
            userSessionBean.setSessionBrowserNum( browserFloat02.floatValue() );
            userSessionBean.setSessionUserProfileNum( userProfileInteger.intValue() );
            theSession.setAttribute( "userSessionBean", userSessionBean );

            // theSession.setAttribute( "sessionOS", theOSForSession.toString() );
            theStatement.close();
            connPool.free( theCon );
        } catch ( SQLException SQLEx ) {
            // println( "SQLEXception occurred: \n" + SQLEx.getMessage() );
            SQLEx.printStackTrace();
        } // end try/catch
         
    } // end method processRequest 
    
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
        UpdateProfileForm uPForm = ( UpdateProfileForm ) form;
        forwardString = "";
        try {
            if ( this.fieldsAreBad( uPForm ) ) {
                forwardString = "failure";
            } else {
                this.processRequest( uPForm, request );
                forwardString = "success";
            } // if ( this.fieldsAreBad( uPForm ) ) 
        } catch ( IOException ioEx ) {
            // println( "IOException calling processRequest" );
            ioEx.printStackTrace( System.out );
            forwardString = "failure";
        } // end try/catch  
               
        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.UpdateProfileAction
