/*
 * ContactUsAction.java
 *
 * Created on December 22, 2006, 5:26 PM
 */

package net.shellfspace.struts.action;

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
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.UserSessionBean;
import net.shellfspace.struts.form.ContactUsForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 * @version
 */

public class ContactUsAction extends Action {
    
    private String forwardString = null;
    
    protected String processRequest( 
            ContactUsForm contactForm,
            HttpServletRequest request ) {
        String returnString = "success";
        
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessionBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );
                
        String messageText = contactForm.getMessageText();
        String subject = contactForm.getMessageSubject();
        String fromAddress = contactForm.getEmailAddress();      
        
        try {
            Properties props = new Properties();
            // smtp.rcn.com for testing at home, localhost when released
            props.put( "mail.smtp.host", "localhost" );
            // NOTE: Session.getDefaultInstance may stop working under newer implementations
            Session session = Session.getInstance( props, null );
            Message msg = new MimeMessage( session );
            msg.setFrom( new InternetAddress( fromAddress ) );
            InternetAddress[] address = {
                new InternetAddress( "us@ShellfSpace.net" )
            };
            msg.setRecipients( Message.RecipientType.TO, address );
            msg.setSubject( subject );
            msg.setSentDate( new Date() );
            msg.setText( messageText );
            Transport.send( msg );
        } catch ( MessagingException jmme ) {
            returnString = "failure";
            jmme.printStackTrace();
        } // end try/catch
        
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
    public ActionForward execute(
            ActionMapping mapping, 
            ActionForm  form,
            HttpServletRequest request, 
            HttpServletResponse response )
    throws Exception {
        
        // println( "Starting net.shellfspace.struts.action.ContactUsAction.execute()" );
        forwardString = "";
        
        ContactUsForm contactForm = ( ContactUsForm ) form;
        UserSessionBean usBean = new UserSessionBean();
        
        try {
            forwardString = processRequest(  contactForm, request );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
        // println( "Here is forwardString: " + forwardString );
        // println( "Endinging net.shellfspace.struts.action.ContactUsAction.execute()" );
        
        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.ContactUsAction

