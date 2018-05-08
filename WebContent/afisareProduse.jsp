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

	<br>
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
	
	<br>
	
	<table class="table table-condensed">
		<tr>
			<th>Nume</th>
			<th>Stoc</th>
			<th>Pret</th>
			<th></th>
		</tr>
		
		<tr>
			 <c:forEach items="${listaProduse}" var="produs" >
		          <tr>
		             <td>${produs.nume_produs}</td>
		             <td>${produs.stoc}</td>
		             <td>${produs.pret}</td>
		             <td>
		             	<c:if test="${tipUser=='user'}">
		             		<a href= "${pageContext.request.contextPath}/AdaugareInCos?produsAdaugat=${produs.id_produs}">Adauga in cos</a>
						</c:if>
		             <%--
		             
		             	<%
						String contextPath = request.getContextPath();
						%>
						<td>${contextPath}</td>
		                 <c:set var ="produsDeAdaugat" scope ="session" value ="${produs}"/>
		                 <a href="AdaugareInCos">Click me</a>
		             --%>
		             
		             </td>
		          </tr>
		       </c:forEach>
		</tr>
		
	</table>
</body>
</html>