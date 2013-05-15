/*
 * UpdateProfileForm.java
 *
 * Created on August 3, 2006, 11:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
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
 */
public class UpdateProfileForm extends org.apache.struts.action.ActionForm {
    
    /** Creates a new instance of UpdateProfileForm */
    public UpdateProfileForm() {
        super();
    }
    
    // ------------------------------------------------------ Instance Variables
    
    /** warning property */
    private String warning = "";
    
    /** browserName property */
    private String browserName;

    /** browserVersionNumber property */
    private String browserVersionNumber;

    /** OSVersionNumber property */
    private String OSVersionNumber;

    /** OSName property */
    private String OSName;
    	
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
        browserVersionNumber = null;
        OSVersionNumber      = null;
        OSName               = null;
                
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
    
} // end class net.shellfspace.struts.form.UpdateProfileForm
