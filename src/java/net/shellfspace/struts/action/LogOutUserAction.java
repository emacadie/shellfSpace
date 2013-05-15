/*
 * LogOutUserAction.java
 *
 * Created on August 17, 2006, 11:51 PM
 */

package net.shellfspace.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.UserSessionBean;

/**
 *
 * @author ericm
 * @version
 */

public class LogOutUserAction extends Action {
    
    private String forwardString = "success";
    
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
        forwardString = "success";
        // println( "Starting LogOutUserAction.execute" );
        HttpSession theSession = request.getSession( true );
        UserSessionBean userSessionBean = 
            ( UserSessionBean ) theSession.getAttribute( "userSessionBean" );
        
        userSessionBean.setSessionUserNumber( 0 );
        userSessionBean.setSessionUserProfileNum( 0 );
        
        // update the bean in the session
        
        theSession.setAttribute( "userSessionBean", userSessionBean );
        theSession.invalidate( );
                
        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.LogOutUserAction
