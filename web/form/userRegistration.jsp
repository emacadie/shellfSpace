
<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html:html> 
    <head>
    <html:base />
        <jsp:include page="../html/headerTag001.html" />
		<title>User Registration Form</title>
        <!-- html:javascript formName="UserRegistrationForm" / -->
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
        <h1>User Registration Page</h1>
        
         <% 
    // if sessionUserNumber == 0, tell them to log in
    %>
    <logic:equal name="userSessionBean" property="sessionUserNumber" value="0" >
        
        <html:form action="/userRegistration" >
            <bean:write name="UserRegistrationForm" property="warning"
              filter="false"/>
            
        <table>
            
            <!-- onsubmit="return validateInputForm (this)" -->
        <tr><td>BrowserName:</td>
        <td><html:select property="browserName">
         <%
            String browserName;
            for ( int x = 0; x < optionPropertiesBean.getBrowserNameTotal(); x++ ) {
                browserName = optionPropertiesBean.getNamedProperty( "browserName_" + x );
                %>
                <option value="<% out.write( browserName ); %>">
                <% out.write( browserName ); %></option>
                <%
            } %>
            </html:select><html:errors property="browserName"/></td></tr>
            
            <tr><td>Browser Version Number:</td>
            <td> <html:text property="browserVersionNumber"/>
            <html:errors property="browserVersionNumber"/>
        </td>
        </tr>
        
        <tr><td>OS Name:</td>
        <td><html:select property="OSName">
        <%
           String osName;
           for ( int x = 0; x < optionPropertiesBean.getOsNameTotalX(); x++ ) {
               osName = optionPropertiesBean.getNamedProperty( "osName_" + x );
               %>
               <option value="<% out.write( osName ); %>">
               <% out.write( osName ); %></option>
               <%
           } %>
           </html:select><html:errors property="OSName"/>
           </td>
           </tr>
        
        <tr><td>OS Version Number:</td>
        <td><html:text property="OSVersionNumber"/>
            <html:errors property="OSVersionNumber"/>
        </td></tr>
        
        <tr><td>User Name:</td><td><html:text property="userName"/>
            <html:errors property="userName"/>
        </td></tr>
        
        <tr><td>Password:</td><td><html:text property="password"/>
            <html:errors property="password"/>
        </td></tr>
        
        <tr><td>Confirm Password:</td>
        <td><html:text property="confirmPassword"/>
            <html:errors property="confirmPassword"/>
        </td></tr>
        <% /*
        <tr><td>User Number:</td>
        <td><html:text property="userNumber"/>
            <html:errors property="userNumber"/>
        </td></tr>
                    */
        %>
        <tr><td>Email Address:</td>
        <td><html:text property="emailAddress" />
            <html:errors property="emailAddress" />
        </td></tr>
        <tr><td><html:submit /></td><td><html:cancel /></td></tr>
    
       </table>
       </html:form>
       <p>&nbsp;</p>
       <p>Note 1:<br />
       Your email address is only used in case you forget your password. <br />
        If you can think of a way to give someone a forgotten password without shooting them an 
    email, let me know.</p>
        <p>&nbsp;</p>
        <p>Note 2:<br />
        If you are using Linux, type the version number of your distribution, and not the 
        version of your kernel or glibc.<br />
        If the versions of your distribution are commonly referred to by name, please use the 
        corresponding number. Check your distro's homepage, documentation, or 
        <a href="http://www.distrowatch.com" target="new">DistroWatch</a>.</p>
        <p>&nbsp;</p>
        <p>Note 3:<br />
        Version information is stored as a floating-point number.<br />
        If your browser or OS version has more than one decimal point (such as NetBSD 1.5.3, or 
        Galeon 1.0.2), please use only the first decimal point. So you would enter your info as 
        NetBSD 1.53 or Galeon 1.02. If the version number has any letters (like 3.0r0) simply 
        take out the letters.</p>
      
       
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
</html:html>