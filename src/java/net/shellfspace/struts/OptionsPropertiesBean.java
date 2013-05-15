/*
 * OptionsPropertiesBean.java
 *
 * Created on August 2, 2006, 11:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.shellfspace.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 *
 * @author ericm
 */
public class OptionsPropertiesBean {
    
    public OptionsPropertiesBean() {
        intPropSize = 0;
        // println( getDate() + ": Constructing OptionsPropertiesBean" );
	osNameTotalX      = 0;
	browserNameTotal  = 0;
	urlStringTotal    = 0;
	transSuccessTotal = 0;
	yesNoTotal        = 0;
	typeOfTransTotal  = 0;
	typeOfSiteTotal   = 0;
	startProp();
	getTotals();
    } // end constructor
    
    Properties myProp = new Properties();
    int intPropSize;
    int osNameTotalX;
    int browserNameTotal;
    int urlStringTotal;
    int transSuccessTotal;
    int yesNoTotal;
    int typeOfTransTotal;
    int typeOfSiteTotal;
    
    public String getNamedProperty( String name ) {
        return myProp.getProperty( name );
    }    
    
    /**
     * @return Returns the browserNameTotal.
     */
    public int getBrowserNameTotal() {
        return browserNameTotal;
    }

    /**
    * @return Returns the osNameTotal.
     */
    public int getOsNameTotalX() {
        return osNameTotalX;
    }
    
    /**
     * @return Returns the transSuccessTotal.
     */
    public int getTransSuccessTotal() {
        return transSuccessTotal;
    }
    
    /**
     * @return Returns the typeOfSiteTotal.
     */
    public int getTypeOfSiteTotal() {
        return typeOfSiteTotal;
    }
    
    /**
     * @return Returns the typeOfTransTotal.
     */
    public int getTypeOfTransTotal() {
        return typeOfTransTotal;
    }
    
    /**
     * @return Returns the urlStringTotal.
     */
    public int getUrlStringTotal() {
        return urlStringTotal;
    }
    
    /**
     * @return Returns the yesNoTotal.
     */
    public int getYesNoTotal() {
        return yesNoTotal;
    }

    public void getTotals() {
        try {    
            osNameTotalX      = Integer.parseInt( myProp.getProperty( "osNameTotal" ) );
            browserNameTotal  = Integer.parseInt( myProp.getProperty( "browserNameTotal" ) );
            urlStringTotal    = Integer.parseInt( myProp.getProperty( "urlStringTotal" ) );
            transSuccessTotal = Integer.parseInt( myProp.getProperty( "transSuccessTotal" ) );
            yesNoTotal        = Integer.parseInt( myProp.getProperty( "yesNoTotal" ) );
            typeOfTransTotal  = Integer.parseInt( myProp.getProperty( "typeOfTransTotal" ) );
            typeOfSiteTotal   = Integer.parseInt( myProp.getProperty( "typeOfSiteTotal" ) );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
        }
        
    } // end method getTotals
    
    
    public int getIntPropSize() {
        if ( intPropSize == 0 ) {
            startProp();
        }
        intPropSize = myProp.size();
        return intPropSize;
    }
        
    public void startProp() {
        
        try {
            InputStream is = getClass().getResourceAsStream( "/options.properties" );
            myProp.load( is ); // this may throw IOException
            
            // println( "In OptionsPropertiesBean.startProp" );
            // println( "Size of properties is: " + myProp.size() );
        } catch ( IOException ioe ) {
            // println( "Properties loading failed in AppConfig" );
            ioe.printStackTrace( System.out ); 
        } catch ( NullPointerException npEx ) {
            // println( "NullPointerException" );
            // println( "Here is the message: " +  npEx.getMessage() );
            npEx.printStackTrace( System.out );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
        } // end try/catch
    } // end method startProp
	
    private String getDate() {
        GregorianCalendar theCal = new GregorianCalendar();
        return ( theCal.get( Calendar.YEAR ) + "-" +
            ( theCal.get( Calendar.MONTH ) + 1 ) + "-" +
            theCal.get( Calendar.DATE ) + "-" +
            theCal.get( Calendar.HOUR ) + ":" +
            theCal.get( Calendar.MINUTE ) + ":" +
            theCal.get( Calendar.SECOND )
        );
    } // end method getDate
    
} // end class net.shellfspace.struts.OptionsPropertiesBean
