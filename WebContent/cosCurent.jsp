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
	
	<p style="text-align: right"><a href="LogoutServlet">Logout</a></p>
	
	<br>
	<h2>Cos Curent</h2>
	<c:set var="suma" value="${0}" />
	
	<table class="table table-hover">
		<%--
		<c:if test="${not empty ${cos}">
			<c:out value="Cosul dumneavoastra este gol"></c:out>
		</c:if>
  		--%>
		<tr>
			<th>Nume</th>
			<th>Pret</th>
			<th>Cantitate</th>
			<th>Mareste Cantitatea</th>
			<th>Scade Cantitatea</th>
		</tr>
		
		<c:forEach items="${listaCos}" var="ob" >
		          <tr>
		             <td>${ob.p.nume_produs}</td>
		     		 <td>${ob.p.pret}</td>
		     		 <td>${ob.cantitate}</td>
		             <td>
			             <a href="${pageContext.request.contextPath}/AdaugareInCos?produsAdaugat=${ob.p.id_produs}" > +</a>
		             </td>
		             <td>
		             	<a href="${pageContext.request.contextPath}/StergeCos?produsSters=${ob.p.id_produs}" > -</a>
		             </td>
		         		            
		            <c:set var="suma" value="${suma+ob.p.pret*ob.cantitate}" />
		          </tr>
		 </c:forEach>
	</table>
	<br>
	<h2>Valoare Comanda: <c:out value="${suma}" /></h2>
	<a href="PlaseazaComanda" > Plaseaza Comanda</a>
	
	<%
		HttpSession session1=request.getSession();
		session1.removeAttribute("negasit");
		session1.removeAttribute("gasit");	
	%>
</body>
</html>