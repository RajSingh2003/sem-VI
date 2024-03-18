<html>
<head>
<title>
	Simple JSP Page
</title>
</head>
<body>
<%
	String vuname=request.getParameter("txtuser");
	String vpwd=request.getParameter("txtpwd");
	out.println("Username : "+vuname);
	out.println("Password : "+vpwd);
%>
<hr>
<br>
<a href="index.html">Home</a>
</body>

</html>
	
	
