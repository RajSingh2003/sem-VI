<%@ page import="java.io.*,java.util.*"%>
<html>
<head>
</head>
<body>
<a herf = "JSP">Click</a>
    <%
      Date date = new Date();
       out.print("<h2 align= \" center \" >" + date.toString()+"</h2>");
    %>
</body>
</html>

