<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Tipo de Fundo</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nomeTipoFundo.value;
		if (validaNome.trim() == "") {
			alert('Digite um nome valido');
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="/fundos/tipo-de-fundo/alterar"
		method="POST" onkeypress='return event.keyCode!=13'>
		<input type="hidden" name="id" value="${tipo.id}"/>
		Tipo de Fundo: <input name="nomeTipoFundo" value="${tipo.nomeTipoFundo}" pattern="[a-z\s]+$" autofocus="autofocus"/><br /> <input
			type="button" value="Alterar" onclick='validar()' />
	</form>
</body>
</html>