/*
 * SiteAddForm.java
 *
 * Created on April 26, 2006, 10:54 PM
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

public class SiteAddForm extends org.apache.struts.action.ActionForm {
    
    private String siteName;
    private String siteURL;
    private String siteURLString;
    private String transSuccess;
    private String typeOfTrans;
    private String needCookies;
    private String needJavascript;
    private String needFlash;
    private String needJavaVM;
    private String typeOfSite;
        
    /**
     *
     */
    public SiteAddForm() {
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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName( String siteName ) {
        this.siteName = siteName;
    }

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL( String siteURL ) {
        this.siteURL = siteURL;
    }

    public String getSiteURLString() {
        return siteURLString;
    }

    public void setSiteURLString( String siteURLString ) {
        this.siteURLString = siteURLString;
    }

    public String getTransSuccess() {
        return transSuccess;
    }

    public void setTransSuccess( String transSuccess ) {
        this.transSuccess = transSuccess;
    }

    public String getTypeOfTrans() {
        return typeOfTrans;
    }

    public void setTypeOfTrans( String typeOfTrans ) {
        this.typeOfTrans = typeOfTrans;
    }

    public String getNeedCookies() {
        return needCookies;
    }

    public void setNeedCookies( String needCookies ) {
        this.needCookies = needCookies;
    }

    public String getNeedJavascript() {
        return needJavascript;
    }

    public void setNeedJavascript( String needJavascript ) {
        this.needJavascript = needJavascript;
    }

    public String getNeedFlash() {
        return needFlash;
    }

    public void setNeedFlash( String needFlash ) {
        this.needFlash = needFlash;
    }

    public String getNeedJavaVM() {
        return needJavaVM;
    }

    public void setNeedJavaVM( String needJavaVM ) {
        this.needJavaVM = needJavaVM;
    }

    public String getTypeOfSite() {
        return typeOfSite;
    }

    public void setTypeOfSite( String typeOfSite ) {
        this.typeOfSite = typeOfSite;
    }
  /*  
    mysql> desc site_entry;
+---------------------+---------------------+------+-----+---------+----------------+
| Field               | Type                | Null | Key | Default | Extra          |
+---------------------+---------------------+------+-----+---------+----------------+
| site_increment      | int(10) unsigned    | NO   | PRI | NULL    | auto_increment |
| site_name           | varchar(25)         | YES  |     | NULL    |                |
| site_url            | varchar(30)         | YES  |     | NULL    |                |
| user_counter        | int(10) unsigned    | NO   |     | NULL    |                |
| user_profile_number | tinyint(3) unsigned | NO   |     | NULL    |                |
| cookies_needed      | enum('y','n')       | NO   |     | NULL    |                |
| javascript_needed   | enum('y','n')       | NO   |     | NULL    |                |
| flash_needed        | enum('y','n')       | NO   |     | NULL    |                |
| javavm_needed       | enum('y','n')       | NO   |     | NULL    |                |
| type_of_transaction | varchar(20)         | YES  |     | NULL    |                |
| type_of_site        | varchar(20)         | YES  |     | NULL    |                |
| success             | varchar(15)         | NO   |     | NULL    |                |
| text_comment        | varchar(50)         | YES  |     | NULL    |                |
| url_string          | varchar(10)         | YES  |     | NULL    |                |
| date_entered        | date                | YES  |     | NULL    |                |
+---------------------+---------------------+------+-----+---------+----------------+
*/
    
    public void truncateFields() {
        StringBuffer tempString = new StringBuffer();
        tempString.delete( 0, tempString.length() );
        try {
            for ( int ggg = 0; ggg < this.getSiteName().length(); ggg++ ) {
                if ( this.getSiteName().charAt( ggg ) == '\'' ) {
                    tempString.append( "\\" );
                    tempString.append( this.getSiteName().charAt( ggg ) );
                } else {
                    tempString.append( this.getSiteName().charAt( ggg ) );
                }
            } // end for ( int ggg = 0; ggg < argSiteName.length(); ggg++ )
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
        } // end try/catch
        
        if ( siteName.length() > 25 ) {
            tempString.append( this.getSiteName() );
            this.setSiteName( tempString.substring( 0, 24 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( siteName.length() > 25 )
        if ( siteURL.length() > 30 ) {
            tempString.append( this.getSiteURL() );
            this.setSiteURL( tempString.substring( 0, 29 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( siteURL.length() > 30 )
        if ( typeOfTrans.length() > 20 ) {
            tempString.append( this.getTypeOfTrans() );
            this.setTypeOfTrans( tempString.substring( 0, 19 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( typeOfTrans.length() > 20 )
        if ( typeOfSite.length() > 20 ) {
            tempString.append( this.getTypeOfSite() );
            this.setTypeOfSite( tempString.substring( 0, 19 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( typeOfSite.length() > 20 )
        if ( transSuccess.length() > 15 ) {
            tempString.append( this.getTransSuccess() );
            this.setTransSuccess( tempString.substring( 0, 14 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( transSuccess.length() > 15 )
        if ( siteURLString.length() > 10 ) {
            tempString.append( this.getSiteURLString() );
            this.setSiteURLString( tempString.substring( 0, 9 ) );
            tempString.delete( 0, tempString.length() );
        } // if ( siteURLString.length() > 10 )
        
    } // end method truncateFields
    
} // end class net.shellfspace.struts.form.SiteAddForm
