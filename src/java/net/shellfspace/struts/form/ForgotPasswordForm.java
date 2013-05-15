/*
 * ForgotPasswordForm.java
 *
 * Created on October 12, 2006, 6:54 PM
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

public class ForgotPasswordForm extends org.apache.struts.action.ActionForm {
    
    private String userName;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }    
    
    /**
     *
     */
    public ForgotPasswordForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
        /*
        if ( getName() == null || getName().length() < 1 ) {
            errors.add( "name", new ActionMessage( "error.name.required" ) );
            // TODO: add 'error.name.required' key to your resources
        }
         */
        return errors;
    } // end method validate


    
} // end class net.shellfspace.struts.form.ForgotPasswordForm

