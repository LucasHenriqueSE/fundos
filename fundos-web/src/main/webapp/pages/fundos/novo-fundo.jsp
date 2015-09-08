<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Fundos</title>
</head>
<body>
	<form action="/fundos/salvar" method="POST">
		Nome: <input name="nome" value="" />
<!-- 		Cotas: <input name="listaCotas" type="hidden" value="" /> -->
<!-- 		Movimentos: <input name="listaMovimentos" type="hidden" value="" /><br/> -->
		
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>