/*
 * SearchForm.java
 *
 * Created on May 2, 2006, 10:14 PM
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

public class SearchForm extends org.apache.struts.action.ActionForm {
    
    private String siteURL;
    private String operatingSystem;
    private String browser;
    private String successValue;
    
    /**
     *
     */
    public SearchForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
        /* ---------------------------------------------------------------------
        if ( getName() == null || getName().length() < 1 ) {
            errors.add( "name", new ActionMessage( "error.name.required" ) );
            // TODO: add 'error.name.required' key to your resources
        }
        --------------------------------------------------------------------- */
        return errors;
    } // end method validate

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL( String siteURL ) {
        this.siteURL = siteURL;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem( String operatingSystem ) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser( String browser ) {
        this.browser = browser;
    }

    public String getSuccessValue() {
        return successValue;
    }

    public void setSuccessValue( String successValue ) {
        this.successValue = successValue;
    }
    
} // end class net.shellfspace.struts.form.SearchForm 
