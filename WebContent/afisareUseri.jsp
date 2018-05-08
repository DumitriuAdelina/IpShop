<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*,entitati.Useri"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
     <table class="table table-hover">
		<tr>
			<th>Nume</th>
			<th>Parola</th>
			<th>Email</th>
			<th>Telefon</th>
			<th>Adresa</th>
			<th>Tip</th>
			<th></th><th></th>
		</tr>
		
		<tr>
			 <c:forEach items="${listaUseri}" var="user" >
		          <tr>
		             <td>${user.nume_prenume}</td>
		             <td>${user.parola}</td>
		             <td>${user.email}</td>
		             <td>${user.telefon}</td>
		             <td>${user.adresa}</td>
		             <td>${user.tip}</td>
		             <td>
		             	<a href= "${pageContext.request.contextPath}/BlocheazaUseri?userBlocat=${user.id_user}">Blocheaza</a>
		             	/
		             	<a href= "${pageContext.request.contextPath}/DeblocheazaUseri?userDeblocat=${user.id_user}">Deblocheaza</a>
		             	<%-- <a href= "editareProfil.jsp?userCurent=${user}">Editeaza User</a> --%>				
		             	
		             </td>
		          </tr>
		       </c:forEach>
		</tr>
		
	</table>
            
</body>
</html>