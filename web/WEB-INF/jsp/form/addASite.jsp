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
    <title>Add a Site</title>
    
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
  
  
         <html:form action="/siteAdd">
            
            siteName : <html:text property="siteName" />
            <html:errors property="siteName"/><br />
            siteURL [Note 1 below] : <html:text property="siteURL" />
            <html:errors property="siteURL"/><br />          
            
            Were any of the following strings in the site's URL?<br />
            [Note 2 below] [Note 3 below] <br />
                <html:select property="siteURLString">
                 <%
           String urlStringX;
           for ( int x = 0; x < optionPropertiesBean.getUrlStringTotal(); x++ ) {
               urlStringX = optionPropertiesBean.getNamedProperty( "urlString_" + x );
               %>
               <option value="<% out.write( urlStringX ); %>">
               <% out.write( urlStringX ); %></option>
               <%
           } %>
                </html:select>
                <br />
                
                Transaction successful?<br />
                <html:select property="transSuccess">
                <html:option value="Yes">Yes</html:option>
                <html:option value="No:browser err">No: "browser error"</html:option>
                <html:option value="No:passport">No: Passport needed</html:option>
                <html:option value="No:Javascript">No: Javascript problems</html:option>
                <html:option value="No:other">No: other reason</html:option>
                </html:select><br />
            
                Type of Transaction<br />
                <html:select property="typeOfTrans">               
           <%
           String typeOfTransX;
           for ( int x = 0; x < optionPropertiesBean.getTypeOfTransTotal(); x++ ) {
               typeOfTransX = optionPropertiesBean.getNamedProperty( "typeOfTrans_" + x );
               %>
               <option value="<% out.write( typeOfTransX ); %>">
               <% out.write( typeOfTransX ); %></option>
               <%
           } %>
                
                </html:select><br />
            
                Cookies needed<br />
                <html:select property="needCookies">
                <html:option value="y">Yes</html:option>
                <html:option value="n">No</html:option>
                </html:select><br />
                            
                Javascript needed<br />
                <html:select property="needJavascript">
                <html:option value="y">Yes</html:option>
                <html:option value="n">No</html:option>
                </html:select><br />
            
                Flash needed<br />
                <html:select property="needFlash">
                <html:option value="y">Yes</html:option>
                <html:option value="n">No</html:option>
                </html:select><br />
            
                JRE/Java VM needed<br />
                <html:select property="needJavaVM">
                <html:option value="y">Yes</html:option>
                <html:option value="n">No</html:option>
                </html:select><br />
            
                Type of Site<br />
                <html:select property="typeOfSite">
            <%
           String typeOfSiteX;
           for ( int x = 0; x < optionPropertiesBean.getTypeOfSiteTotal(); x++ ) {
               typeOfSiteX = optionPropertiesBean.getNamedProperty( "typeOfSite_" + x );
               %>
               <option value="<% out.write( typeOfSiteX ); %>">
               <% out.write( typeOfSiteX ); %></option>
               <%
           } %>               
               </html:select><br />
                
                <br />Make the world safe for Unix now!<br />
                            
            <html:submit/>
            <html:cancel/>
            
            
        </html:form>
        
        <!-- --------------------------------------------------------------- -->
        <p>&nbsp;</p>
        <p>Note 1:<br />
        Please include the domain and subdomain, but not the whole URL. <br /> 
        bpstore.hp.com is better than just hp.com or 
        bpstore.hp.com/cgi-bin/hpbs/initsession.jsp</p>
        
        <p>&nbsp;</p>
        <p>Note 2:<br />
        Sometimes the URL contains a string that tells you what sort of 
        server-side technology a site is using. If you did not see any of 
        the options listed or did not bother to look, please select &quot;N/A&quot;.<br />
        If you saw a URL which contained both /cgi-bin/ and another listed 
        option (such as .pl, .py or .woa), please select the other option.<br />

        Examples:<br />
        <a href="http://www.distrowatch.com/table.php?distribution=libranet">
        http://www.distrowatch.com/table.<b><u><i>php</i></u></b>?distribution=libranet</a><br />
        <a href="http://slashdot.org/search.pl?query=java">
        http://slashdot.org/search.<b><u><i>pl</i></u></b>?query=java</a><br />
        <a href="http://solutionsmarketplace.oracle.com/MainServlet?ksAction=Home">
        http://solutionsmarketplace.oracle.com/Main<b><u><i>Servlet</i></u></b>?ksAction=Home</a><br />
        <a href="http://www.chicagofilmfestival.org/cgi-bin/WebObjects/filmfest.woa/wa/go?page=theaters">
        http://www.chicagofilmfestival.org/cgi-bin/WebObjects/filmfest<b><u><i>.woa</i></u></b>/wa/go?page=theaters</a><br />
        <a href="http://www.fortune.com/indexw.jhtml?channel=artcol.jhtml&doc_id=207012">
        http://www.fortune.com/indexw.<b><u><i>jhtml</i></u></b>?channel=artcol.jhtml&doc_id=207012</a><br />
        <a href="http://maps.yahoo.com/py/maps.py?BFCat=&Pyt=Tmap&newFL=Use+Address+Below&addr=231+South+LaSalle&csz=60604&Country=us&Get%A0Map=Get+Map">
        http://maps.yahoo.com/py/maps.<b><u><i>py</i></u></b>?BFCat=&Pyt=Tmap&newFL=Use+Address&<br />addr=231+South+LaSalle&csz=60604&Country=us&Get%A0Map=Get+Map</a><br />
        (This is where I work)<br />
        </p>
        
        <p>&nbsp;</p>
        <p>Note 3:<br />
        Sometimes you may see these file extensions with another letter appended:<br />
        http://www.javablogs.com/Welcome.<b>jspa</b><br />
        http://www.cafeshops.com/cp/store.<b>aspx</b>?s=debiangear<br />
        In these cases, simply select the extension provided by the form.</p>
        
        <!-- ----------------------------------------------------------- -->
        </logic:notEqual>
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>