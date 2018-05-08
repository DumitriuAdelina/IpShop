<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String mesaj = (String) session.getAttribute("eroare");
		if (mesaj != null) {
	%>
	
	<br>
	<h3><%=mesaj%></h3>
	<br>
	
	<%
		session.invalidate();
		}
	%>
	<h2>Logare</h2><br>
	<form method="post" action="LoginCheck">
    <div class="form-group">
      <label for="email">Email:</label>
      <input class="form-control" type="text" name="username" placeholder="Enter email">
    </div>
	<div class="form-group">
      <label for="pwd">Password:</label>
      <input class="form-control" type="password" name="password" placeholder="Enter password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	<%	
			HttpSession session1=request.getSession();
			session1.removeAttribute("cos");
	%>
</body>
</html>