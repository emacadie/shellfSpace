
<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
 
<html> 

    <head>
    <jsp:include page="../html/headerTag001.html" />
        <title>Login Form</title>
    </head>
    <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />
    <body>
    <jsp:include page="../html/header001.html" />
    <h1>Login Page</h1>
     
    <% // if sessionUserNumber == 0, tell them to log in
    %>
    <logic:equal name="userSessionBean" property="sessionUserNumber" value="0" >
    <p>User Number: <bean:write name="userSessionBean" property="sessionUserNumber" /></p>
        <html:form action="/userLogin">
            
            userName : <html:text property="userName" />
            <html:errors property="userName" /><br />
            
            password : <html:text property="password" />
            <html:errors property="password" /><br />
            
            <html:submit/>
            <html:cancel/>
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
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
    </logic:equal>
     <%  // if sessionUserNumber != 0, display their information 
    %>
    <logic:notEqual name="userSessionBean" property="sessionUserNumber" value="0" >
    <p>User Number: <bean:write name="userSessionBean" property="sessionUserNumber" /></p>
    <p>Hello, <bean:write name="userSessionBean" property="sessionUserName" /></p>
    <p>You have already logged in. Please go to the <a href="../jsp/memberMainPage.jsp">
    Member Main Page</a>.</p>
    <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
    </logic:notEqual>
     <jsp:include page="../html/footer001.html" />
    </body>
    
</html>