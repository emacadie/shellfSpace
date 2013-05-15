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
    <title>Search the database</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
 <body>
 <jsp:include page="../html/header001.html" />
  
  
         <html:form action="/search">
             
             siteURL: <html:text property="siteURL" />
            <html:errors property="siteURL"/><br /> 
            
            Operating System<br />
            <html:select property="operatingSystem">
            <html:option value=""></html:option>
            <html:option value="FreeBSD">FreeBSD</html:option>
            <html:option value="Mac OS X">Mac OS X</html:option>
            <html:option value="NetBSD">NetBSD</html:option>
            <html:option value="OpenBSD">OpenBSD</html:option>
            <html:option value="Debian GNU/Linux">Debian GNU/Linux</html:option>
            <html:option value="Gentoo Linux">Gentoo Linux</html:option>
            <html:option value="Linux From Scratch">Linux From Scratch</html:option>
            <html:option value="Libranet GNU/Linux">Libranet GNU/Linux</html:option>
            <html:option value="LindowsOS">LindowsOS</html:option>
            <html:option value="Lycoris Desktop/LX">Lycoris Desktop/LX</html:option>
            <html:option value="Mandrake Linux">Mandrake Linux</html:option>
            <html:option value="Red Hat Linux">Red Hat Linux</html:option>
            <html:option value="Slackware Linux">Slackware Linux</html:option>
            <html:option value="Sorcerer Linux">Sorcerer Linux</html:option>
            <html:option value="SuSE Linux">SuSE Linux</html:option>
            <html:option value="Xandros Linux">Xandros Linux</html:option>
            <html:option value="Yellow Dog Linux">Yellow Dog Linux</html:option>
            <html:option value="SCO">SCO</html:option>
            <html:option value="Darwin">Darwin</html:option>
            <html:option value="BSDOS">BSD/OS</html:option>
            <html:option value="HP-UX">HP-UX</html:option>
            <html:option value="IRIX">IRIX</html:option>
            <html:option value="Solaris">Solaris</html:option>
            </html:select><br />

            Browser:<br />
            <html:select property="browser">
            <html:option value=""></html:option>
            <html:option value="Mozilla">Mozilla</html:option>
            <html:option value="Galeon">Galeon</html:option>
            <html:option value="Konqueror">Konqueror</html:option>
            <html:option value="Opera">Opera</html:option>
            <html:option value="Nautilus">Nautilus</html:option>
            <html:option value="Netscape">Netscape</html:option>
            <html:option value="skipstone">Skipstone</html:option>
            <html:option value="BrowseX">BrowseX</html:option>
            <html:option value="Phoenix">Phoenix</html:option>
            <html:option value="Lynx">Lynx</html:option>
            <html:option value="Mac OS X IE">IE on Mac OS X (shame on you!!!)</html:option>
            </html:select><br />
            
            Search for transactions that were<br />
            <html:select property="successValue">
            <html:option value=" "> </html:option>
            <html:option value="yes">Successful</html:option>
            <html:option value="no">Unsuccessful</html:option>
            <html:option value="all">Search for all</html:option>
            </html:select><br />
            

                <br />Make the world safe for Unix now!<br />
                            
            <html:submit/>
            <html:cancel/>
            
            
        </html:form>
        
<!-- ======================================================================= -->
        
    
    <jsp:include page="../html/footer001.html" />
    
  </body>
  
</html:html>