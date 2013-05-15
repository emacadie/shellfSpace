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
    <title>Option Bean Tester</title>
    
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

    <h1>Option Bean Tester Page</h1>
    
    <!--  if sessionUserNumber == 0, tell them to log in -->
    <logic:equal name="userSessionBean" property="sessionUserNumber" value="0" >
         <p>Your user number is 0. Please <a href="../form/userLogin.jsp">log in</a>.</p>
    </logic:equal>
    
    <logic:notEqual name="userSessionBean" property="sessionUserNumber" value="0" >
    <p>Welcome, <bean:write name="userSessionBean" property="sessionUserName" /></p>
    
    <p>Email address: <bean:write name="userSessionBean" property="sessionUserEmail" /></p>
    
    <p>Browser: <bean:write name="userSessionBean" property="sessionBrowser" /></p>
    
    <p>OS: <bean:write name="userSessionBean" property="sessionOS" /></p>
    
    <p>User Number: <bean:write name="userSessionBean" property="sessionUserNumber" /></p>
    
    <p>User Profile Number: <bean:write name="userSessionBean" 
        property="sessionUserProfileNum" />
    </p>
    </logic:notEqual>
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    <jsp:include page="../html/footer001.html" />
    
    </body>
</html:html>
