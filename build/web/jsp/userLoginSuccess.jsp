<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    <jsp:include page="../html/headerTag001.html" />
    <title>Login Success</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />
  
  <body>
  <jsp:include page="../html/header001.html" />
    <!-- bean:write name="userName" scope="request" />, you successfully logged in! -->
    <p>SUCCESSFUL LOGIN</p>
    <p>Welcome, <bean:write name="userSessionBean" property="sessionUserName" /></p>
    
    <p>Email address: <bean:write name="userSessionBean" property="sessionUserEmail" /></p>
    
    <p>Browser: <bean:write name="userSessionBean" property="sessionBrowser" />
    &nbsp;<bean:write name="userSessionBean" property="sessionBrowserNum" />
    </p>
    
    <p>OS: <bean:write name="userSessionBean" property="sessionOS" />
    &nbsp;<bean:write name="userSessionBean" property="sessionOSNum" />
    </p>
    
    <p>User Number: <bean:write name="userSessionBean" property="sessionUserNumber" /></p>
    
    <p>User Profile Number: <bean:write name="userSessionBean" property="sessionUserProfileNum" />
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