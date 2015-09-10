<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Movimento Fundo</title>
</head>
<body>
	<form action="/fundos/movimentos/salvar" method="POST">
		Valor: <input name="valorMovimentoFundo" value="" />
		Quantidade: <input name="qtdMovimentoFundo" value="" />
		Valor Cota: <input name="valorCotaMovimentoFundo" value="" /><br/>
		<!-- 		Data:  -->
		
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>