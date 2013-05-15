<%@ page contentType="text/html"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    <jsp:include page="../html/headerTag001.html" />
    <title>Add a Site</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  
 <body>
 <jsp:include page="../html/header001.html" />
    Hello <!-- bean:write name="userName" scope="request" />.<br />
    Welcome to ShellfSpace.<br />
    Browser name: <!-- bean:write name="browserName" scope="request" /><br />
    Browser version: <!-- bean:write name="browserVersionNumber" scope="request" /><br />
    OS Name: <!-- bean:write name="OSName" scope="request" /><br />
    OS Number: <!-- bean:write name="OSVersionNumber" scope="request" /><br />
    Email Address:<!-- bean:write name="emailAddress" scope="request" / --><br />
    
    Thank you for flying. The following was added to the database:<br />
    Site name: <bean:write name="SiteAddForm" property="siteName" /><br />
    Site URL: <bean:write name="SiteAddForm" property="siteURL" /><br />
    URL Technology String: <bean:write name="SiteAddForm" property="siteURLString" /><br />
    Transaction successful: <bean:write name="SiteAddForm" property="transSuccess" /><br />
    Type of transaction: <bean:write name="SiteAddForm" property="typeOfTrans" /><br />
    Cookies needed: <bean:write name="SiteAddForm" property="needCookies" /><br />
    Javascript needed: <bean:write name="SiteAddForm" property="needJavascript" /><br />
    Flash needed: <bean:write name="SiteAddForm" property="needFlash" /><br />
    Java Needed: <bean:write name="SiteAddForm" property="needJavaVM" /><br />
    Type of site: <bean:write name="SiteAddForm" property="typeOfSite" /><br />
       
    
    <!-- 
    
                out.println( "<p>Here are the parameters: </p>" );
                out.println( "<ul>" );
                out.println( "<li>Site Name: " + argSiteName + "</li>" );
                out.println( "<li>Site URL: " + argURL + "</li>" );
                out.println( "<li>URL String: " + argURLString + "</li>" );
                out.println( "<li>Type of Transaction: " + argTypeOfTrans + "</li>" );
                out.println( "<li>Need for cookies: " + argNeedCookies + "</li>" );
                out.println( "<li>Need for javascript: " + argNeedJavaScript + "</li>" );
                out.println( "<li>Need for Flash: " + argNeedFlash + "</li>" );
                out.println( "<li>Need for Java: the world cannot get enough Java</li>" );
                out.println( "</ul>" );
                out.println( "<p>&nbsp;</p><p>You are logged in as " + 
                    ( String )theSession.getAttribute( "sessionUserName" ) + "</p>" 
                );
                
                -->
    
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>