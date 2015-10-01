<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8" />
<title>Cadastro de Fundos</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nome.value;
		var validaTipo = form1.tipoFundo.value;
		if (validaNome.trim() == "") {
			alert('Digite um nome valido');
			return false;
		}
		if (validaTipo == "") {
			alert('Selecione um tipo');
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="/fundos/salvar" method="POST"
		onkeypress='return event.keyCode!=13'>
		Nome: <input name="nome" value="" autofocus="autofocus" />
		Tipo de Fundo: <select id="tipoFundo" name="tipoFundo.id">
			<option value="">Selecione...</option>
			<c:forEach var="tipo" items="${tipos}">
				<option value="${tipo.id}">${tipo.nomeTipoFundo}</option>
			</c:forEach>
		</select><br />
		<input type="button" value="Cadastrar" onclick='validar()' />
	</form>
</body>
</html>