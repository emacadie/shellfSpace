/*
 * SiteAddAction.java
 *
 * Created on April 26, 2006, 10:59 PM
 */

package net.shellfspace.struts.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.UserSessionBean;
import net.shellfspace.struts.form.SiteAddForm;
import net.shellfspace.util.ConnectionPool;


/**
 *
 * @author ericm
 * @version
 */

public class SiteAddAction extends Action {
    
    ConnectionPool connPool;
    Connection theCon;
    private String forwardString;
    
    public SiteAddAction() {
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
    
    private String getDate() {
        GregorianCalendar theCal = new GregorianCalendar();
        return ( theCal.get( java.util.Calendar.YEAR ) + "-" +
            ( theCal.get( java.util.Calendar.MONTH ) + 1 ) + "-" +
            theCal.get( java.util.Calendar.DATE )
        );
    } // end method getDate
    
    protected String processRequest( 
            SiteAddForm siteAddForm, HttpServletRequest request )
    throws IOException {
        
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessionBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );
        String result = "";
        int userInt = 0;
        
        try {
            
            Connection theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); 
            theStatement.clearBatch();
                           
            int executeResult = 0;
            executeResult = theStatement.executeUpdate( 
                "insert into site_entry( " +
                "site_name, site_url, user_counter, user_profile_number, " +
                "cookies_needed, javascript_needed, flash_needed, " +
                "javavm_needed, type_of_transaction, type_of_site, " +
                "url_string, success, date_entered) values " + "('" + 
                siteAddForm.getSiteName() + "', '" + siteAddForm.getSiteURL() + 
                "', '" + userSessionBean.getSessionUserNumber( ) + 
                "', '" + userSessionBean.getSessionUserProfileNum( ) + 
                "', '" + siteAddForm.getNeedCookies() + "', '" + 
                siteAddForm.getNeedJavascript() + "', '" + 
                siteAddForm.getNeedFlash() + "', '" + 
                siteAddForm.getNeedJavaVM() + "', '" + 
                siteAddForm.getTypeOfTrans() + "', '" + 
                siteAddForm.getTypeOfSite() + "', '" + 
                siteAddForm.getSiteURLString() + "', '" + 
                siteAddForm.getTransSuccess()  + "', '" + getDate() +"')"
            );
            
            /* println( "debug: Here is the query:\n" +
                "insert into site_entry( " +
                "site_name, site_url, user_counter, user_profile_number, " +
                "cookies_needed, javascript_needed, flash_needed, " +
                "javavm_needed, type_of_transaction, type_of_site, url_string, " +
                "success, date_entered) values " + "('" + 
                siteAddForm.getSiteName() + "', '" + siteAddForm.getSiteURL() + 
                "', '" + userSessionBean.getSessionUserNumber( ) + 
                "', '" + userSessionBean.getSessionUserProfileNum( ) + 
                "', '" + siteAddForm.getNeedCookies() + "', '" + 
                siteAddForm.getNeedJavascript() + "', '" + 
                siteAddForm.getNeedFlash() + "', '" + 
                siteAddForm.getNeedJavaVM() + "', '" + 
                siteAddForm.getTypeOfTrans() + "', '" + 
                siteAddForm.getTypeOfSite() + "', '" + 
                siteAddForm.getSiteURLString() + "', '" + 
                siteAddForm.getTransSuccess()  + "', '" + getDate() +"')"
            );
            */
            
            if ( executeResult == 0 ) {
                result = "failure";
            } else {
                result = "success";
            } // if ( executeResult == 0 )
            
            theStatement.close();
            connPool.free( theCon );
        } catch ( SQLException SQLEx ) {
            // println( "SQLEXception occurred: \n" + SQLEx.getMessage() );
            SQLEx.printStackTrace( System.out );
            /* println( "<p>Here is the statement:\n " +
                "insert into site_entry( " +
                "site_name, site_url, user_counter, user_profile_number, " +
                "cookies_needed, javascript_needed, flash_needed, " +
                "javavm_needed, type_of_transaction, type_of_site, url_string, " +
                "success, date_entered) values " + "('" + 
                 siteAddForm.getSiteName() + "', '" + siteAddForm.getSiteURL() + 
                 "', '" + userSessionBean.getSessionUserNumber( ) + 
                 "', '" + userSessionBean.getSessionUserProfileNum( ) + 
                 "', '" + siteAddForm.getNeedCookies() + "', '" + 
                 siteAddForm.getNeedJavascript() + "', '" + 
                 siteAddForm.getNeedFlash() + "', '" + 
                 siteAddForm.getNeedJavaVM() + "', '" + 
                 siteAddForm.getTypeOfTrans() + "', '" + 
                 siteAddForm.getTypeOfSite() + "', '" + 
                 siteAddForm.getSiteURLString() + "', '" + 
                 siteAddForm.getTransSuccess()  + "', '" + getDate() +"')"
            );
            */
            result = "failure";
        }  // end try/catch
        
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
            ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response )
    throws Exception {
        
        SiteAddForm siteAddForm = ( SiteAddForm ) form;
        
        try {
            siteAddForm.truncateFields();
            forwardString = processRequest( siteAddForm, request );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
        return mapping.findForward( forwardString );
        
    } // end method execute 
    
} // end class net.shellfspace.struts.action.SiteAddAction
