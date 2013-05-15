/*
 * SearchActionResultStructure.java
 *
 * Created on May 4, 2006, 10:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.shellfspace.struts;

/**
 *
 * @author ericm
 */
public class SearchActionResultStructure {
    
    /** Creates a new instance of SearchActionResult */
    public SearchActionResultStructure() {
        // println( "SearchActionResultStructure" );
    }
    
    private String siteName;
    private String siteURL;
    private String typeOfTransaction;
    private String typeOfSite;
    private String urlString;
    private String operatingSystem;
    private float opSysVersion;
    private String browser;
    private float browserVersion;
    private String cookies;
    private String javascript;
    private String flash;
    private String javaVM;
    private String success;
    private String dateEntered;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName( String siteName ) {
        this.siteName = siteName;
    }

    public String getSiteURL() {
        // println( "Here is SearchActionResultStructure.siteURL: " + siteURL );
        return siteURL;
    }

    public void setSiteURL( String siteURL ) {
        this.siteURL = siteURL;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction( String typeOfTransaction ) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getTypeOfSite() {
        return typeOfSite;
    }

    public void setTypeOfSite( String typeOfSite ) {
        this.typeOfSite = typeOfSite;
    }

    public String getUrlString() {
        // println( "Here is SearchActionResultStructure.urlString: " + urlString );
        return urlString;
    }

    public void setUrlString( String urlString ) {
        this.urlString = urlString;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem( String operatingSystem ) {
        this.operatingSystem = operatingSystem;
    }

    public float getOpSysVersion() {
        return opSysVersion;
    }

    public void setOpSysVersion( float opSysVersion ) {
        this.opSysVersion = opSysVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser( String browser ) {
        this.browser = browser;
    }

    public float getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion( float browserVersion ) {
        this.browserVersion = browserVersion;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies( String cookies ) {
        this.cookies = cookies;
    }

    public String getJavascript() {
        return javascript;
    }

    public void setJavascript( String javascript ) {
        this.javascript = javascript;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash( String flash ) {
        this.flash = flash;
    }

    public String getJavaVM() {
        return javaVM;
    }

    public void setJavaVM( String javaVM ) {
        this.javaVM = javaVM;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess( String success ) {
        this.success = success;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered( String dateEntered ) {
        this.dateEntered = dateEntered;
    }
                    
    
} // end class net.shellfspace.struts.SearchActionResultStructure
