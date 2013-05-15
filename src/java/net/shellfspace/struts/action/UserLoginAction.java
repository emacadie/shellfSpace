/*
 * UserLoginAction.java
 *
 * Created on April 24, 2006, 10:28 PM
 */

package net.shellfspace.struts.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.UserSessionBean;
import net.shellfspace.struts.form.UserLoginForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 * @version
 */

public class UserLoginAction extends Action {
    
    ConnectionPool connPool;
    Connection theCon;
    private String forwardString;
    
    public UserLoginAction() {
        forwardString = "";
        try {
            this.connPool = new ConnectionPool();
        } catch ( SQLException sqlEx ) {
            sqlEx.printStackTrace( System.out );
            // println( "SQLException in constructor for UserLoginAction" );
            // println( sqlEx.getMessage() );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            // println( "Exception in constructor for UserLoginAction" );
            // println( e.getMessage() );
        } // end try/catch
    } // end constructor

    
    protected String processRequest( 
            UserLoginForm userLoginForm, 
            HttpServletRequest request, 
            UserSessionBean userSessionBean )
    throws IOException {
        String result = "";
        HttpSession theSession = request.getSession( true );
        
        boolean emptySet = true;
        String browser = null;
        String OS;
        int counter = 0;
                
        try {
            
            Connection theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); 
        
            // check if user exists here
            theStatement.clearBatch();
            ResultSet rSet = theStatement.executeQuery( "select a.browser, " +
                " a.operating_system, c.user_counter, " +
                " a.browser_version, a.kernel_version, c.profile_number, " +
                "c.email_address " +
                "from user_entry_current c, user_entry_archive a " +
                "where (c.user_id_name='" + userLoginForm.getUserName() + 
                "') and (c.password='" + userLoginForm.getPassword() + 
                "') and (c.user_counter = a.user_counter)" +
                " and (c.profile_number = a.user_profile_number)"
            );
                        
            while ( rSet.next() ) {
                if ( rSet.wasNull() ) { 
                	emptySet = true; 
                } else { 
                	emptySet = false; 
                }
                browser = new String( rSet.getString( 1 ) );
                OS = rSet.getString( 2 );                
                Integer theCount = new Integer( rSet.getInt( 3 ) );
                Float bVer = new Float( rSet.getFloat( 4 ) );
                Float osVer = new Float( rSet.getFloat( 5 ) );
                Integer profNum = new Integer( rSet.getInt( 6 ) );
                String email = new String( rSet.getString( 7 ) );
                                
                // populate UserSessionBean object
                userSessionBean.setSessionUserName( userLoginForm.getUserName() );
                userSessionBean.setSessionUserNumber( theCount.intValue() );
                userSessionBean.setSessionUserProfileNum( profNum.intValue() );
                userSessionBean.setSessionUserEmail( email );
                userSessionBean.setSessionBrowserNum( bVer.floatValue() );
                userSessionBean.setSessionBrowser( browser );
                userSessionBean.setSessionOS( OS );
                userSessionBean.setSessionOSNum( osVer.floatValue() );
                
                theSession.setAttribute( "userSessionBean", userSessionBean  );
                
            } // end while ( rSet.next() )
            
            if ( emptySet ) {
                result = "failure";
            } else {
                result = "success";
            } // end if/else ( emptySet ) 
            
            connPool.free( theCon );
                        
        } catch ( SQLException SQLEx ) {
            SQLEx.printStackTrace();
 
            /*
             println( "SQL EXception: Here is the statement:\n>" +
                "select a.browser, " +
                " a.operating_system, c.user_counter, " +
                " a.browser_version, a.kernel_version, c.profile_number, " +
                "c.email_address " +
                "from user_entry_current c, user_entry_archive a " +
                "where (c.user_id_name='" + userLoginForm.getUserName() + 
                "') and (c.password='" + userLoginForm.getPassword() + 
                "') and (c.user_counter = a.user_counter)" +
                " and (c.profile_number = a.user_profile_number)"
            );
             */
        } // end try/catch
        return result;
         
    } // end method processRequest
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public synchronized ActionForward execute(
            ActionMapping mapping, 
            ActionForm  form,
            HttpServletRequest request, 
            HttpServletResponse response )
    throws Exception {
        
        forwardString = "";
        
        UserLoginForm userLoginForm = ( UserLoginForm ) form;
        UserSessionBean usBean = new UserSessionBean();
        
        try {
            forwardString = processRequest( userLoginForm, request, usBean );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.UserLoginAction
