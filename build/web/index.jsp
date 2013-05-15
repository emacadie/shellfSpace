

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
    <style type="text/css" media="all">@import "html/layout1.css";</style>
<link rel="shortcut icon" href="images/shellfSpace.ico" />
    
    <title>Welcome to ShellfSpace</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
<div id="Logo">
<img src="images/shellfSpaceNewsPrint002.png"
     alt="Shellf Space"
     height="50"
     width="356" />
</div>
<div id="Header">
<a href="http://www.shellfspace.net/" title="Shellf Space">Shellf Space.net</a>
 -- Advocating UNIX-based systems for desktop use in e-commerce
</div>

<div id="Menu">
<a href="html/mainPage.html">Welcome Page</a><br />
<a href="form/userRegistration.jsp">Register</a><br />
<a href="form/userLogin.jsp">Login</a> <br />
<a href="jsp/memberMainPage.jsp">Member Main Page</a><br />
<a href="form/updateProfile.jsp">Update profile</a> <br />
<a href="form/addASite.jsp">Add a site</a><br />
<a href="form/logOut.jsp">Log out</a> <br />
<a href="form/search.jsp">Search Page</a><br />
<a href="form/suggestNewType.jsp">Suggestion Box</a><br />
<a href="html/faq.html">FAQ</a><br />
<a href="html/links.html">Links</a><br />
<a href="html/reactions.html">Reactions</a><br />
<a href="form/contactUsPage.jsp">Contact us</a><br />
</div>
<div id="Content">
   
    
    <h2>Welcome to Shellf Space.</h2>
<p>&nbsp;</p>
<p>This is a site devoted to promoting Linux, BSD and other UNIX-based operating systems 
for desktop use and in e-commerce by tracking which sites allow a UNIX-based
system to successfully complete an online transaction.</p>
<p>&nbsp;</p>

<p>With the impending threats of DRM (via hardware and/or legislation), .NET and 
Palladium, what better way to promote UNIX-based systems than to let businesses know you use 
your UNIX-based desktop to spend money?</p>
<p>&nbsp;</p>

<p>Shellf Space is a simple Java web application which connects to a database that 
keeps track of which sites allow a UNIX-based desktop to complete an account lookup, a 
product search which leads to an off-line purchase or a complete e-commerce transaction.</p>
<p>&nbsp;</p>

<p>To search the database, go to the <a href="form/search.jsp">Search Page</a>.</p>
<p>&nbsp;</p>

<p>To add a site or update your profile, login 
<a href="form/userLogin.jsp">here</a>.</p>
<p>&nbsp;</p>

<p>To register, click <a href="form/userRegistration.jsp">here</a>. 
(You must first register to add a site. You do not need a profile to search the database.)</p>
<p>&nbsp;</p>

<p>If you have registered but forgot your password, click 
<a href="forgotInfo.html">here</a></p>
 

    
    <jsp:include page="html/footer001.html" />
  </body>
</html:html>
