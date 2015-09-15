<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Novo Movimento Fundo</title>
</head>
<body>
	<form id="form1" name="form1" action="/fundos/movimentos/salvar"
		method="POST" onsubmit='return event.keyCode!=13'>
		Valor: <input name="valorMovimentoFundo" value="" />
		Quantidade: <input name="qtdMovimentoFundo" value="" />
		Valor Cota: <input name="valorCotaMovimentoFundo" value="" /><br />
		Data: 

		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>