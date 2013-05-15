/*
 * UserSessionBean.java
 *
 * Created on April 25, 2006, 9:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.shellfspace.struts;

/**
 *
 * @author ericm
 */
public class UserSessionBean {
    
    /** Creates a new instance of UserSessionBean */
    public UserSessionBean() {
        sessionUserName       = "";
        sessionUserNumber     = 0;
        sessionUserProfileNum = 0;
        sessionUserEmail      = "";
        sessionBrowserNum     = 0;
        sessionBrowser        = "";
        sessionOS             = "";
        sessionOSNum          = 0; 
    } // end constructor
    
    private String sessionUserName;
    
    private int sessionUserNumber;
    
    private int sessionUserProfileNum;
    
    private String sessionUserEmail;
    
    private float sessionBrowserNum;
    
    private String sessionBrowser;
    
    private String sessionOS;
    
    private float sessionOSNum; 

    public String getSessionUserName() {
        return sessionUserName;
    }

    public void setSessionUserName( String sessionUserName ) {
        this.sessionUserName = sessionUserName;
    }

    public int getSessionUserNumber() {
        return sessionUserNumber;
    }

    public void setSessionUserNumber( int sessionUserNumber ) {
        this.sessionUserNumber = sessionUserNumber;
    }

    public int getSessionUserProfileNum() {
        return sessionUserProfileNum;
    }

    public void setSessionUserProfileNum( int sessionUserProfileNum ) {
        this.sessionUserProfileNum = sessionUserProfileNum;
    }

    public String getSessionUserEmail() {
        return sessionUserEmail;
    }

    public void setSessionUserEmail( String sessionUserEmail ) {
        this.sessionUserEmail = sessionUserEmail;
    }

    public float getSessionBrowserNum() {
        return sessionBrowserNum;
    }

    public void setSessionBrowserNum( float sessionBrowserNum ) {
        this.sessionBrowserNum = sessionBrowserNum;
    }

    public String getSessionBrowser() {
        return sessionBrowser;
    }

    public void setSessionBrowser( String sessionBrowser ) {
        this.sessionBrowser = sessionBrowser;
    }

    public String getSessionOS() {
        return sessionOS;
    }

    public void setSessionOS( String sessionOS ) {
        this.sessionOS = sessionOS;
    }

    public float getSessionOSNum() {
        return sessionOSNum;
    }

    public void setSessionOSNum( float sessionOSNum ) {
        this.sessionOSNum = sessionOSNum;
    }
    
} // end class net.shellfspace.struts.UserSessionBean
