/*
 * ForgotPasswordAction.java
 *
 * Created on October 12, 2006, 6:56 PM
 */

package net.shellfspace.struts.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.form.ForgotPasswordForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 * @version
 */

public class ForgotPasswordAction extends Action {
    
    ConnectionPool connPool;
    Connection theCon;
    private String forwardString = "success";
    
    public ForgotPasswordAction() {
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
    
    protected String processRequest( 
            ForgotPasswordForm forgotPasswordForm,
            HttpServletRequest request ) {
        
        String returnString = "success";
        String userNameParam = forgotPasswordForm.getUserName();
                
        boolean emptySet = true;
        StringBuffer theQueryBuff = new StringBuffer();
        theQueryBuff.append( "select password, email_address from user_entry_current " +
            "where user_id_name = '" + userNameParam +"'"  
        );
        String sqlResultPassword = null;
        String sqlResultEmail    = null;
        try {
            Connection theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); 
            // check if user exists here
            theStatement.clearBatch();
            ResultSet rSet = theStatement.executeQuery( theQueryBuff.toString() );
            while ( rSet.next() ) {
                if ( rSet.wasNull() ) { 
                    emptySet = true;
                } else {
                    emptySet = false;
                    sqlResultPassword = rSet.getString( 1 );
                    sqlResultEmail = rSet.getString( 2 );
                    if ( !rSet.isFirst() ) { 
                        break; 
                    }
                } // if ( rSet.wasNull() )
            } // end while ( rSet.next() )
        } catch ( SQLException SQLEx ) {
            // println( "SQLException occurred:\n" + SQLEx.getMessage() );
        } catch ( Exception e ) {
            // println( "Exception occurred:\n" + e.getMessage() );
            e.printStackTrace();
        } // end try/catch
        
        if ( emptySet ) {
            returnString = "failure";
        } else {
                        
            try {
                Properties props = new Properties();
                // smtp.rcn.com for testing at home, localhost when released
                props.put( "mail.smtp.host", "localhost" );
                // NOTE: Session.getDefaultInstance may stop working under newer implementations
                Session session = Session.getInstance( props, null );
                Message msg = new MimeMessage( session );
                msg.setFrom( new InternetAddress( "ShellfSpace@ShellfSpace.net" ) );
                InternetAddress[] address = { new InternetAddress( sqlResultEmail ) };
                msg.setRecipients( Message.RecipientType.TO, address );
                msg.setSubject( "The Password for your Shellf Space Account" );
                msg.setSentDate( new Date() );
                msg.setText( "The password for the Shellf Space user " + 
                    userNameParam + " is: " + sqlResultPassword + 
                    "\n\nThank you for spacing out\n\nShellf Space dot Net\n\n" 
                );
                Transport.send( msg );
            } catch ( MessagingException jmme ) {
                returnString = "failure";
                jmme.printStackTrace();
            } // end try/catch
        } // end if ( emptySet )/else
        
        return returnString;
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
        
        ForgotPasswordForm forgotPasswordForm = ( ForgotPasswordForm ) form;
        try {
            forwardString = processRequest( forgotPasswordForm, request );
        } catch ( Exception e ) {
            forwardString = "failure";
            e.printStackTrace();
        }
        
        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.ForgotPasswordAction
