<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Tipo de Fundo</title>
</head>
<body>
	<form action="/tipo-de-fundo/salvar" method="POST">
		Tipo de Fundo: <input name="nomeTipoFundo" value=""/><br/>
	
		<input type="submit" value="Cadastrar" />
	
	</form>
</body>
</html>