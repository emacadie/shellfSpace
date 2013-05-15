<%@ page contentType="text/html"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html> 
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log Out Form</title>
        <jsp:include page="../html/headerTag001.html" />
		
        <!-- html:javascript formName="UserRegistrationForm" / -->
    </head>

    
    <body>
    
        <jsp:include page="../html/header001.html" />
        <h1>Log Out</h1>
        <html:form action="/logOutUser" >
        <table>      

            			
     <% // <html:submit value="Submit, Mistress" />
     %>
    <html:cancel value="Logout" />
    
       </table>
       </html:form>
       
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
       
       <jsp:include page="../html/footer001.html" />
    </body>
</html:html>