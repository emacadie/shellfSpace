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
    <title>Shellf Space Site Contact Form</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
       <jsp:useBean
        id="optionPropertiesBean"
        scope="application"
        class="net.shellfspace.struts.OptionsPropertiesBean" />
   
 <body>
 
 <jsp:include page="../html/header001.html" />
 
 <h1>Contact Us</h1>

  
  
         <html:form action="/contactUs">
            
               <br />
                
               Name : <html:text property="userName" />
            <html:errors property="userName"/><br />
            Email address: 
            <html:text property="emailAddress" />
            <html:errors property="emailAddress"/><br />
            Subject: 
            <html:text property="messageSubject" />
            <html:errors property="messageSubject"/><br />
            
            <br />
                
                Message (any URLs, examples, explanations):<br />
                <html:textarea rows="10" cols="48" property="messageText">
                </html:textarea>
               
                <br />
                
                <br />Express yourself<br />
                            
            <html:submit/>
            <html:cancel/>
                
        </html:form>
        
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        
    
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>
