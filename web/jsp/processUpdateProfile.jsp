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
    <title>Update Profile Results</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
 <body>
 <jsp:include page="../html/header001.html" />
 <h1>Update Profile Results</h1>

      <p>Hello, <bean:write name="userSessionBean" property="sessionUserName" /></p>
    
    <p>Email address: <bean:write name="userSessionBean" property="sessionUserEmail" /></p>
    
    <p>Browser: <bean:write name="userSessionBean" property="sessionBrowser" />
    &nbsp;<bean:write name="userSessionBean" property="sessionBrowserNum" />
    </p>
    
    <p>OS: <bean:write name="userSessionBean" property="sessionOS" />
    &nbsp;<bean:write name="userSessionBean" property="sessionOSNum" />
    </p>
    
    <p>User Number: <bean:write name="userSessionBean" property="sessionUserNumber" /></p>
    
    <p>User Profile Number: <bean:write name="userSessionBean" 
        property="sessionUserProfileNum" />
    </p>
    <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
  
   
<jsp:include page="../html/footer001.html" />
    
    </body>
</html:html>
