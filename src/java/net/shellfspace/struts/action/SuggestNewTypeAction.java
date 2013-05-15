/*
 * SuugestNewTypeAction.java
 *
 * Created on October 9, 2006, 3:42 PM
 */

package net.shellfspace.struts.action;

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
import net.shellfspace.struts.form.SuggestNewTypeForm;

import java.util.Date;
import java.util.Properties;

/**
 *
 * @author ericm
 * @version
 */

public class SuggestNewTypeAction extends Action {
    
    private static String forwardString = "success";
    
    protected String processRequest( 
            SuggestNewTypeForm suggestNewTypeForm,
            HttpServletRequest request ) {
        String returnString = "success";
        
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessionBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );
                
        String messageParam = suggestNewTypeForm.getMessage();
        String newItemParam = suggestNewTypeForm.getNewItem();
        
        try {
            Properties props = new Properties();
            // smtp.rcn.com for testing at home, localhost when released
            props.put( "mail.smtp.host", "localhost" );
            // NOTE: Session.getDefaultInstance may stop working under newer implementations
            Session session = Session.getInstance( props, null );
            Message msg = new MimeMessage( session );
            msg.setFrom( new InternetAddress( userSessionBean.getSessionUserEmail() ) );
            InternetAddress[] address = {
                new InternetAddress( "ShellfSpaceSuggestion@ShellfSpace.net" )
            };
            msg.setRecipients( Message.RecipientType.TO, address );
            msg.setSubject( newItemParam );
            msg.setSentDate( new Date() );
            msg.setText( newItemParam + "\n" + messageParam );
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
    public synchronized ActionForward execute( 
            ActionMapping mapping, 
            ActionForm  form,
            HttpServletRequest request, 
            HttpServletResponse response )
    throws Exception {
        
        SuggestNewTypeForm suggestNewTypeForm = ( SuggestNewTypeForm ) form;
        try {
            forwardString = processRequest( suggestNewTypeForm, request );
        } catch ( Exception e ) {
            forwardString = "failure";
            e.printStackTrace();
        }

        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.SuggestNewTypeAction

