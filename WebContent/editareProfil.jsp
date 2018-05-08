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
	<h2>Editeaza Date</h2>
	<br>
	<form method="POST" action="EditareProfil">
            <table  class="table table-hover" border="0">
               
               <tr>
                  <td>Nume</td>
                  <td><input type="text" name="nume_prenume" value="${userCurent.nume_prenume}" /></td>
               </tr>
               <tr>
                  <td>Parola</td>
                  <td><input type="text" name="parola" value="${userCurent.parola}" /></td>
               </tr>
               <tr>
                  <td>Email</td>
                  <td><input type="text" name="email" value="${userCurent.email}" /></td>
               </tr>
               <tr>
                  <td>Telefon</td>
                  <td><input type="text" name="telefon" value="${userCurent.telefon}" /></td>
               </tr>
               <tr>
                  <td>Adresa</td>
                  <td><input type="text" name="adresa" value="${userCurent.adresa}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="index.jsp">Cancel</a>
                  </td>
               </tr>
            
            </table>
         </form>
	
	<%
		HttpSession session1=request.getSession();
		session1.removeAttribute("negasit");
		session1.removeAttribute("gasit");	
	%>
	
</body>
</html>