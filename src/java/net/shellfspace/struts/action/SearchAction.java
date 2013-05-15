/*
 * SearchAction.java
 *
 * Created on May 2, 2006, 10:16 PM
 */

package net.shellfspace.struts.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import net.shellfspace.struts.SearchActionResultStructure;
import net.shellfspace.struts.form.SearchForm;
import net.shellfspace.util.ConnectionPool;

/**
 *
 * @author ericm
 * @version
 */

public class SearchAction extends Action {
    
    private ConnectionPool connPool;
    private Connection theCon;
    private String forwardString;
    
    public SearchAction() {
        forwardString = "";
        try {
            this.connPool = new ConnectionPool();
        } catch ( SQLException sqlEx ) {
            sqlEx.printStackTrace( System.out );
            // println( "SQLException in constructor for UserLoginAction" );
            // println( sqlEx.getMessage() );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            // println( "Exception in constructor for UserLoginAction" );
            // println( e.getMessage() );
        } // end try/catch
    } // end constructor
    
    protected String processRequest( 
            SearchForm searchForm, HttpServletRequest request ) {
        HttpSession theSession = request.getSession( true );
        String argURL       = searchForm.getSiteURL();
        String argSuccess   = searchForm.getSuccessValue();
        String argBrowser   = searchForm.getBrowser();
        String argOS        = searchForm.getOperatingSystem();
        String result = "";
        boolean cannotContinue = false;
        StringBuffer theQueryBuff = new StringBuffer(
            "select site_entry.site_name, site_entry.site_url, " +
            "site_entry.type_of_transaction, site_entry.type_of_site, site_entry.url_string, " +
            "user_entry_archive.operating_system, " +
            "user_entry_archive.kernel_version, user_entry_archive.browser, " +
            "user_entry_archive.browser_version, site_entry.cookies_needed, " +
            "site_entry.javascript_needed, site_entry.flash_needed, " +
            "site_entry.javavm_needed, site_entry.success, " +
            "site_entry.date_entered" +
            " from site_entry, user_entry_archive where " +
            "( site_entry.user_counter=user_entry_archive.user_counter ) " + 
            "and ( site_entry.user_profile_number=user_entry_archive.user_profile_number )"
        );
        
        try {
        
            if ( argURL.length() > 4 ) {
                theQueryBuff.append( " and ( site_entry.site_url like '%" );
                theQueryBuff.append( argURL.trim() );
                theQueryBuff.append( "%' )" );
            }
            if ( argBrowser.length() > 0 ) {
                theQueryBuff.append( " and ( user_entry_archive.browser like '%" );
                theQueryBuff.append( argBrowser );
                theQueryBuff.append( "%' )" );
            }
            if ( argOS.length() > 0 ) {
                theQueryBuff.append( " and ( user_entry_archive.operating_system like '%" );
                theQueryBuff.append( argOS );
                theQueryBuff.append( "%' )" );
            }
            if ( argSuccess.length() > 1 ) {
                if ( argSuccess.equalsIgnoreCase( "yes" ) ) {
                    theQueryBuff.append( "and ( site_entry.success=\"yes\" )" );
                } else { 
                    theQueryBuff.append( "and ( site_entry.success!=\"yes\" )" ); 
                }
            }
            theQueryBuff.append( " order by site_entry.site_name" );
        } catch ( Exception e ) {
            /*
            println( "Exception adding to StringBuffer theQueryBuff " +
                "in class net.shellfspace.struts.action.SearchAction"
            );
            println( "Here is the StringBuffer theQueryBuff:\n" + 
                theQueryBuff
            );
            */
            e.printStackTrace( System.out );
        } // end try/catch
        
        try {
            ArrayList searchResultSetList = new ArrayList();
            Connection theCon = connPool.getConnection();
            Statement theStatement = theCon.createStatement(); 
            // check if user exists here
            theStatement.clearBatch();
            
            ResultSet rSet = theStatement.executeQuery( theQueryBuff.toString() );
            while ( rSet.next() ) {
                                
                SearchActionResultStructure saResultStructure = 
                        new SearchActionResultStructure();
                saResultStructure.setSiteName( rSet.getString( 1 ) );
                saResultStructure.setSiteURL( rSet.getString( 2 ) );
                saResultStructure.setTypeOfTransaction( rSet.getString( 3 ) );
                saResultStructure.setTypeOfSite( rSet.getString( 4 ) );
                saResultStructure.setUrlString( rSet.getString( 5 ) );
                saResultStructure.setOperatingSystem( rSet.getString( 6 ) );
                saResultStructure.setOpSysVersion( rSet.getFloat( 7 ) );
                saResultStructure.setBrowser( rSet.getString( 8 ) );
                saResultStructure.setBrowserVersion( rSet.getFloat( 9 ) );
                saResultStructure.setCookies( rSet.getString( 10 ) );
                saResultStructure.setJavascript( rSet.getString( 11 ) );
                saResultStructure.setFlash( rSet.getString( 12 ) );
                saResultStructure.setJavaVM( rSet.getString( 13 ) );
                saResultStructure.setSuccess( rSet.getString( 14 ) );
                saResultStructure.setDateEntered( rSet.getDate( 15 ).toString() );
                
                searchResultSetList.add( saResultStructure );
                
            } // end while( rSet.next() )
            request.setAttribute( "searchResultSetList", searchResultSetList );
            
            connPool.free( theCon );
            result = "success";
            
        } catch ( SQLException SQLEx ) {
            result = "failure";
            // println( "SQLException occurred:\n" + SQLEx.getMessage() );
            SQLEx.printStackTrace( System.out );
        } catch ( Exception e ) {
            // println( "Exception occurred:\n" + e.getMessage() );
            e.printStackTrace( System.out );
            result = "failure";
        } // end try/catch
        return result;
               
    } // end method processRequest
    
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
        SearchForm searchForm = ( SearchForm ) form;
        try {
            forwardString = processRequest( searchForm, request );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
        return mapping.findForward( forwardString );
        
    } // end method execute
    
} // end class net.shellfspace.struts.action.SearchAction
