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
	<p style="text-align: right">
		<a href="LogoutServlet">Logout</a>
	</p>
	<br>
	<h2>Adauga Produs</h2>
	<form method="post" action="AddProdServlet">
		<table class="table table-hover">
			<tr>
				<td>Nume Produs</td>
				<td><input type="text" name="nume_produs"></td>
			</tr>
			<tr>
				<td>Stoc</td>
				<td><input type="text" name="stoc"></td>
			</tr>
			<tr>
				<td>Pret</td>
				<td><input type="text" name="pret"></td>
			</tr>
			<tr colspan="5">
				<td>Categorie</td>
				<td><input type="radio" name="id_categorie" value="1" >Telefoane</td>
				<td><input type="radio" name="id_categorie" value="2" >Televizoare</td>
				<td><input type="radio" name="id_categorie" value="3" >Laptopuri</td>
				<td><input type="radio" name="id_categorie" value="4" >Tablete</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Adauga">
					<a href="index.jsp">Cancel</a>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>