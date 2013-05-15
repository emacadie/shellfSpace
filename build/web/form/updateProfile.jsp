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
        id="optionPropertiesBean"
        scope="application"
        class="net.shellfspace.struts.OptionsPropertiesBean" />
        
        <jsp:useBean
        id="userSessionBean"
        scope="session"
        class="net.shellfspace.struts.UserSessionBean" />        
       
    <body>
    
        <jsp:include page="../html/header001.html" />
    <h1>Update Profile</h1>    
        
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
    
    
    <%  // if sessionUserNumber != 0, go ahead
    %>
    <logic:notEqual name="userSessionBean" property="sessionUserNumber" value="0" >
        
        <html:form action="/updateProfile" >
            <bean:write name="UpdateProfileForm" property="warning"
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
        

            			
     <html:submit /><html:cancel />
    
       </table>
       </html:form>
       
       
       </logic:notEqual>
       
       <jsp:include page="../html/footer001.html" />
    </body>
</html:html>
