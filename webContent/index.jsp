<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<jsp:useBean id="arquivos" type="java.util.List" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Imagens</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header class="header">
		<p><a href="#">Login</a></p>
		<p><a href="upload.jsp">Upload de imagem</a></p>
		<p><a href="#">Registrar</a></p>	
	</header>
	<section class="busca">
		<input type="search">
		<input type="submit" value="Buscar">
	</section>
	
	<ul class="images">
	<c:forEach var="arquivo" items="${arquivos}">
		<li>
			<a href="downloadpage?id=${arquivo.id}">
				<img src="mostrarimagem?id=${arquivo.id}" class="image">
			</a>
		</li>
		
		<!-- <p>${arquivo.nome}</p> -->	
	</c:forEach>
	</ul>
</body>
</html>