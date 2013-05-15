/*
 * UserLoginForm.java
 *
 * Created on April 24, 2006, 10:25 PM
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

public class UserLoginForm extends org.apache.struts.action.ActionForm {
    
    /**
     *
     */
    public UserLoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // --------------------------------------------------------- Instance Variables
    
    /** password property */
    private String password;
    
    /** userName property */
    private String userName;
    
    // --------------------------------------------------------- Methods
    
    /** 
     * Returns the password.
     * @return String
     */
    public String getPassword() {
        return password;
    }
    
    /** 
     * Set the password.
     * @param password The password to set
     */
    public void setPassword( String password ) {
        this.password = password;
    }
    
    /** 
     * Returns the userName.
     * @return String
     */
    public String getUserName() {
        return userName;
    }
    
    /** 
     * Set the userName.
     * @param userName The userName to set
     */
    public void setUserName( String userName ) {
        this.userName = userName;
    }
    
    /** 
     * Method reset
     * @param mapping
     * @param request
     */
    public void reset( ActionMapping mapping, HttpServletRequest request ) {
        this.resetAll();
    } // end method reset
    
    public void resetAll() {
        password = null;
        userName = null;
    } // end method resetAll
    
    public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
        /* ---------------------------------------------------------------------
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        --------------------------------------------------------------------- */
        return errors;
    } // end method validate
    
} // end class net.shellfspace.struts.form.UserLoginForm
