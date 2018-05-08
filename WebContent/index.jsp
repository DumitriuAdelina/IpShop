<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,entitati.Produse"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- afisare produse --%>
	<br></br>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="index.jsp">It Shop</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="index.jsp">Home</a></li>
	      <li><a href="${pageContext.request.contextPath}/afisProdServlet?idCategorie=${1}" >Telefoane</a></li>
	      <li><a href="${pageContext.request.contextPath}/afisProdServlet?idCategorie=${2}" >Televizoare</a></li>
	      <li><a href="${pageContext.request.contextPath}/afisProdServlet?idCategorie=${3}" >Laptopuri</a></li>
	      <li><a href="${pageContext.request.contextPath}/afisProdServlet?idCategorie=${4}" >Tablete</a></li>
	      </ul>
	  </div>
	</nav>
	
	<%
		String welcome = (String) session.getAttribute("welcome");
		
		if (welcome != null) {
	%>
	<p style="text-align:right"><a href="LogoutServlet">Logout</a></p>
	<h2>
		Bine ai venit pe IT Store,
		<%=welcome%>!
	</h2>
	<br>
	<a style="color:black;margin-left:10px;border:1px solid;padding:5px;" href="editareProfil.jsp">Editeaza Profilul</a>
	<br><br>
	<%	
	
		String tipUser=(String) request.getSession().getAttribute("tipUser");
	
		if (tipUser.equals("user")) {	
	%>
		<p style="text-align:right"><a style="color:black;margin-left:10px;border:1px solid;padding:5px;" href="cosCurent.jsp">Cos Curent</a></p>
	<% } %>	
	
	
	<%-- cautare produse --%>
	<form method="post" action="CautaProdus">
		<input type="text" name="cautareprodus">
		<input type="submit" value="Cauta Produs">
	</form>
		
	<%
		String mesaj=(String) request.getSession().getAttribute("negasit");
		if (request.getSession().getAttribute("gasit") != null) 
		{
	%>
		<table  class="table table-hover">
			<tr>
				<th>Nume</th>
				<th>Stoc</th>
				<th>Pret</th>
			</tr>		
			<c:forEach items="${gasit}" var="produs" ><tr>
			    <td>${produs.nume_produs}</td>
			    <td>${produs.stoc}</td>
			    <td>${produs.pret}</td>
			</tr></c:forEach>
		</table>	
	<%
		
		}
		else if(mesaj!=null)
		{
			
	%>
	<br>
	<%
			out.print(mesaj);
		}
	%>	
	
	<%	
		if (tipUser.equals("admin")) { 
		
			HttpSession session1=request.getSession();
			session1.removeAttribute("negasit");
			session1.removeAttribute("gasit");	
	
	%>
		<br>
		<a style="color:black;margin-left:10px;border:1px solid;padding:5px;" href="adaugareProdus.jsp">Adauga Produs</a>
		<a style="color:black;margin-left:10px;border:1px solid;padding:5px;" href="afisUseriServlet">Afisare Useri</a>
		<br>
		
	<% } %>
	
	<br>
	<h2>Recomandari</h2>
	<table class="table table-condensed">
		<tr>
			<th>Nume</th>
			<th>Stoc</th>
			<th>Pret</th>
			<th></th>
		</tr>
		
		<tr>
			 <c:forEach items="${listaProdRec}" var="produs" >
		          <tr>
		             <td>${produs.nume_produs}</td>
		             <td>${produs.stoc}</td>
		             <td>${produs.pret}</td>
		          </tr>
		       </c:forEach>
		</tr>
		
	</table>
	
	<%
		} 
		else 
		{
	%>
	
	
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <ul class="nav navbar-nav">
	      <li><a href="login.jsp">Login</a></li>
	      <li><a href="register.jsp">Inregistrare</a></li>
	      </ul>
	  </div>
	</nav>	
	<%
		}
	%>
	
	
</body>
</html>