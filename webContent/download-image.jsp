<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<jsp:useBean id="arquivo" class="br.com.files.model.Arquivo" scope="request"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<header></header>
	<section>
		<img src="mostrarimagem?id=${arquivo.id}" alt="${arquivo.nome}">
		<p>${arquivo.nome}</p>
		<form action="downloadimage?id=${arquivo.id}&nome=${arquivo.nome}" method="post">
			<input type="submit" value="Baixar Imagem">
		</form>
	</section>
</body>
</html>