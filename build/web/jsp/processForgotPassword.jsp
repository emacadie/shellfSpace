<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    <jsp:include page="../html/headerTag001.html" />
    <title>Search Results</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  
 <body>
 <jsp:include page="../html/header001.html" />

    <h1>Search Results</h1>
    
                <table border=1 cellpadding=3>
            <tr>
            <td valign="top">Site name</td><!--  site_entry.site_name -->
            <td valign="top">Site URL</td><!--  site_entry.site_url -->
            <td valign="top">Trans type</td><!--  site_entry.type_of_transaction -->
            <td valign="top">Type of Site</td><!--  site_entry.type_of_site -->
            <td valign="top">URLString</td><!--  site_entry.url_string -->
            <!-- user_entry_archive.operating_system, user_entry_archive.kernel_version -->
            <td valign="top">OS</td>
            <!-- user_entry_archive.browser, user_entry_archive.browser_version -->
            <td valign="top">Browser Type and Settings</td>
            <td valign="top">Success</td><!--  site_entry.success -->
            <td valign="top">Date Entered</td><!--  site_entry.date_entered -->
            </tr>
            <logic:present name="searchResultSetList">
                <logic:iterate id="b" name="searchResultSetList">
                    <tr>
                    <td><bean:write name="b" property="siteName" /></td>
                    <td><bean:write name="b" property="siteURL" /></td>
                    <td><bean:write name="b" property="typeOfTransaction" /></td>
                    <td><bean:write name="b" property="typeOfSite" /></td>
                    <td><bean:write name="b" property="urlString" /></td>
                    <td><bean:write name="b" property="operatingSystem" />
                        <bean:write name="b" property="opSysVersion" /></td>
                    <td><bean:write name="b" property="browser" />
                        <bean:write name="b" property="browserVersion" />
                        <bean:write name="b" property="cookies" />
                        <bean:write name="b" property="javascript" />
                        <bean:write name="b" property="flash" />
                        <bean:write name="b" property="javaVM" /></td>
                    <td><bean:write name="b" property="success" /></td>
                    <td><bean:write name="b" property="dateEntered" /></td>                    
                    </tr>
                    </tr>
                </logic:iterate>
            </logic:present>
            </table>
     <jsp:include page="../html/footer001.html" />
    
    </body>
</html:html>
