<%@page contentType="text/html"%>
<%@page language="java" pageEncoding="UTF-8"%>

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
        <title>Log out</title>
    </head>
    <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />
    <body>
    <jsp:include page="../html/header001.html" />
    <h1>Log out</h1>
    <p>This is jsp/ProcessLogOutUser</p>

    
    <% // if sessionUserNumber == 0, tell them to log in
    %>
    <logic:equal name="userSessionBean" property="sessionUserNumber" value="0" >
         <p>Your user number is 0. Please <a href="../form/userLogin.jsp">log in</a>.</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
    </logic:equal>
    
    <%  // if sessionUserNumber != 0, display their information 
    %>
    <logic:notEqual name="userSessionBean" property="sessionUserNumber" value="0" >
    <p>Hello, <bean:write name="userSessionBean" property="sessionUserName" /></p>
    
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    </logic:notEqual>
    
    <jsp:include page="../html/footer001.html" />
    </body>
</html:html>
