/*
 * SuggestNewTypeForm.java
 *
 * Created on October 9, 2006, 3:34 PM
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

public class SuggestNewTypeForm extends org.apache.struts.action.ActionForm {
    
    private String message;
    private String newItem;
    
    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getNewItem() {
        return newItem;
    }

    public void setNewItem( String newItem ) {
        this.newItem = newItem;
    }
    
    /**
     *
     */
    public SuggestNewTypeForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
        if ( getNewItem() == null || getNewItem().length() < 1 ) {
            errors.add( "newItem", new ActionMessage( "error.newItem.required" ) );
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    } // end method validate
    
    
} // end class net.shellfspace.struts.form.SuggestNewTypeForm


