/*
 * UserRegistrationForm.java
 *
 * Created on April 18, 2006, 11:23 PM
 */

package net.shellfspace.struts.form;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author ericm
 * @version
 */

public class UserRegistrationForm extends org.apache.struts.action.ActionForm {
    
    /**
     *
     */
    public UserRegistrationForm() {
        super();
        // println( "In constructor for UserRegistrationForm" );
    }
    /*
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    */
    ////////////////////////////////////////////////////////////////////////////
    
    // ------------------------------------------ Instance Variables
    
    /** warning property */
    private String warning = "";
    
    /** browserName property */
    private String browserName;

    /** userName property */
    private String userName;

    /** browserVersionNumber property */
    private String browserVersionNumber;

    /** userNumber property */
    private String userNumber;

    /** OSVersionNumber property */
    private String OSVersionNumber;

    /** OSName property */
    private String OSName;
	
    /** emailAddress property */
    private String emailAddress;
	
    /** confirmPassword property */
    private String confirmPassword;
	
    /** password property */
    private String password;

    // --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	
    public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request ) {

	// TODO Auto-generated method stub
        return null;
    } // end method validate
	

    /** 
     * Returns the browserName.
     * @return String
     */
    public String getBrowserName() {
        return browserName;
    }

    /** 
     * Set the browserName.
     * @param browserName The browserName to set
     */
    public void setBrowserName( String browserName ) {
    	this.browserName = browserName;
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
     * Returns the browserVersionNumber.
     * @return String
     */
    public String getBrowserVersionNumber() {
    	return browserVersionNumber;
    }

    /** 
     * Set the browserVersionNumber.
     * @param browserVersionNumber The browserVersionNumber to set
     */
    public void setBrowserVersionNumber( String browserVersionNumber ) {
    	this.browserVersionNumber = browserVersionNumber;
    }
	
    /**
     * Returns the confirmPassword 
     * @return String
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }
	
    /**
     * Set the confirmPassword
     * @param confirmPassword The confirmPassword to set
     */
    public void setConfirmPassword( String confirmPassword ) {
        this.confirmPassword = confirmPassword;
    }
	
    /**
     * Returns the password 
     * @return String
     */
    public String getPassword() {
        return password;
    }
	
    /**
     * Set the password 
     * @param password The password to set
     */
    public void setPassword( String password ) {
        this.password = password;
    }

    /** 
     * Returns the userNumber.
     * @return String
     */
    public String getUserNumber() {
        return userNumber;
    }

    /** 
     * Set the userNumber.
     * @param userNumber The userNumber to set
     */
    public void setUserNumber( String userNumber ) {
        this.userNumber = userNumber;
    }
	
    /**
     * Returns the emailAddress 
     * @return String
     */
    public String getEmailAddress() {
        return emailAddress;
    }
	
    /**
     * Set the emailAddress 
     * @param emailAddress The emailAddress to set
     */
    public void setEmailAddress( String emailAddress ) {
        this.emailAddress = emailAddress;
    }

    /** 
     * Returns the OSVersionNumber.
     * @return String
     */
    public String getOSVersionNumber() {
        return OSVersionNumber;
    }

    /** 
     * Set the OSVersionNumber.
     * @param OSVersionNumber The OSVersionNumber to set
     */
    public void setOSVersionNumber( String OSVersionNumber ) {
        this.OSVersionNumber = OSVersionNumber;
    }

    /** 
     * Returns the OSName.
     * @return String
     */
    public String getOSName() {
        return OSName;
    }

    /** 
     * Set the OSName.
     * @param OSName The OSName to set
     */
    public void setOSName( String OSName ) {
        this.OSName = OSName;
    }
    
    /** 
     * Method reset
     * @param mapping
     * @param request
     */
    public void reset( ActionMapping mapping, HttpServletRequest request ) {
        this.resetAll();
    } // 
	
    public void resetAll() {
        browserName          = null;
        userName             = null;
        browserVersionNumber = null;
        userNumber           = null;
        OSVersionNumber      = null;
        OSName               = null;
        emailAddress         = null;
        confirmPassword      = null;
        password             = null;
    } // end method resetAll

    public String getWarning() {
        return warning;
    }

    public void setWarning( String baseWarning ) {
        this.warning = "<font color=\"red\"><p>You have some issues there, chief:<br /> " +
            baseWarning + "</p></font>";
    }

    public void clearWarning() {
        warning = "";
    } 
    
} // end class net.shellfspace.struts.form.UserRegistrationForm
