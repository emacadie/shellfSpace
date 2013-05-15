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
    <title>Shellf Space Site Suggestion Form</title>
    
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
  
  <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />
  
 <body>
 
 <jsp:include page="../html/header001.html" />
 
 <h1>Add A Site</h1>
 <% // if sessionUserNumber == 0, tell them to log in
    %>
    <logic:equal name="userSessionBean" property="sessionUserNumber" value="0" >
         <p>Your user number is 0.</p> Please <a href="../form/userLogin.jsp">log in</a>.</p>
         <p>You can not add a site because you are not logged in.</p>
         <p>As my roommate from college would say:</p>
         <p>Yeah, hi, you want to <a href="../form/userLogin.jsp">login</a> or 
        <a href="../form/userRegistration.jsp">register</a> before you do this? Thanks.</p>
        
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         <p>&nbsp;</p>
         
    </logic:equal>
    
    
    <%  // if sessionUserNumber != 0, go ahead
    %>
    <logic:notEqual name="userSessionBean" property="sessionUserNumber" value="0" >
  
  
         <html:form action="/suggestNewType">
            
               <br />
                
                I would like to inform Shellf Space of a:<br />
                <html:select property="newItem">
                <html:option value="New Linux Distro">New Linux Distribution</html:option>
                <html:option value="New OS">New Operating System</html:option>
                <html:option value="New File Extension">New File Extension</html:option>
                <html:option value="New Browser">New Browser</html:option>
                <html:option value="New Transaction Type">New Transaction Type</html:option>
                <html:option value="New Site Category">New Site Category</html:option>
                </html:select><br />
                
                Message (any URLs, examples, explanations):<br />
                <html:textarea rows="10" cols="48" property="message">
                </html:textarea>
               
                <br />
                
                <br />Make the world safe for Unix now!<br />
                            
            <html:submit/>
            <html:cancel/>
                
        </html:form>
        
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        
        </logic:notEqual>
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>