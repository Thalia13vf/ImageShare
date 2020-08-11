<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload de Arquivo</title>
</head>
<body>
	<h2>Selecione o arquivo</h2>
	<form enctype="multipart/form-data" action="uploadfile" method="post" >
		<input type="file" name="arquivo" id="arquivo"/>
		<input type="submit" value="Fazer Upload">
	</form>
</body>
</html>