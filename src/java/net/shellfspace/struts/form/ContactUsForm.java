/*
 * ContactUsForm.java
 *
 * Created on December 22, 2006, 5:25 PM
 */

package net.shellfspace.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ericm
 * @version
 */

public class ContactUsForm extends org.apache.struts.action.ActionForm {
    
    private String userName;
    private String emailAddress;
    private String messageSubject;
    private String messageText;
    
    /**
     *
     */
    public ContactUsForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
        /*
        if ( ( getName() == null ) || ( getName().length() < 1 ) ) {
            errors.add( "name", new ActionMessage( "error.name.required" ) );
            // TODO: add 'error.name.required' key to your resources
        }
         */
        return errors;
    } // end method validate

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress ) {
        this.emailAddress = emailAddress;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject( String messageSubject ) {
        this.messageSubject = messageSubject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText( String messageText ) {
        this.messageText = messageText;
    }
    
} // end class net.shellfspace.struts.form.ContactUsForm

