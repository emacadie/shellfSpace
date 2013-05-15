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
    <title>Process Registration</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
 <body>
 <jsp:include page="../html/header001.html" />
    Hello <bean:write name="userName" scope="request" />.<br />
    Welcome to ShellfSpace.<br />
    Browser name: <bean:write name="browserName" scope="request" /><br />
    Browser version: <bean:write name="browserVersionNumber" scope="request" /><br />
    OS Name: <bean:write name="OSName" scope="request" /><br />
    OS Number: <bean:write name="OSVersionNumber" scope="request" /><br />
    Email Address:<bean:write name="emailAddress" scope="request" /><br />
    
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>