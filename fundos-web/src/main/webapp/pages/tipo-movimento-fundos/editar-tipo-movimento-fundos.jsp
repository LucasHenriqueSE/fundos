<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8>
<title>Cadastro Tipo de Movimento Fundos</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nomeTipoMovimentoFundo.value;
		if (validaNome.trim() == "") {
			alert('Informe um nome válido!');
			form1.nomeTipoMovimentoFundo.focus();
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<form id="form1" name="form1"
		action="/fundos/tipo-movimento/alterar" method="POST"
		onsubmit='return event.keyCode!=13'>
		
		Nome: <input name="nomeTipoMovimentoFundo" value="${tipo.nomeTipoMovimentoFundo}" pattern="[a-z\s]+$" autofocus="autofocus"/> <input
			type="button" value="Cadastrar" onclick='validar()' />
	</form>
</body>
</html>