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
<h2>Inregistrare</h2>
<br>
<form method="post" action="RegisterServlet">
		<table class="table table-hover">
			<tr>
				<td>Nume Prenume</td>
				<td><input type="text" name="nume_prenume"></td>
			</tr>
			<tr>
				<td>Parola</td>
				<td><input type="password" name="parola"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Telefon</td>
				<td><input type="text" name="telefon"></td>
			</tr>
			<tr>
				<td>Adresa</td>
				<td><input type="text" name="adresa"></td>
			</tr>
			<tr>
				<td>Tip</td>
				<td><input type="radio" name="tip" value="user" checked> User</td>
  				<%-- <td><input type="radio" name="tip" value="admin"> Admin</td> --%>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>

	</form>


</body>
</html>