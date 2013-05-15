<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"  prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
 
<html:html> 
    <head>
    <html:base />
        <jsp:include page="../html/headerTag001.html" />
		<title>Update Profile Form</title>
        <!-- html:javascript formName="UserRegistrationForm" / -->
    </head>
    
        
        <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />        
       
    <body>
    
        <jsp:include page="../html/header001.html" />
    <h1>Password Retrieval Form</h1>    
    
        <p>Forgot your password? Fill out this form.</p>
        <html:form action="/forgotPassword" >
            
        <table>
            
        <tr><td>Enter user name:</td>
            <td> <html:text property="userName"/>
            <html:errors property="userName"/>
        </td>
        </tr>
            			
     <html:submit value="Send Password" />
    
       </table>
       </html:form>
       
       <jsp:include page="../html/footer001.html" />
       
    </body>
</html:html>
