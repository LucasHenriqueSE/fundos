<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Cadastro de Cotas</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaValor = form1.valor.value;
		var validaData = form1.dataCadastro.value;
		if (validaValor.trim() == "") {
			alert('Informe o valor da cota');
			return false;
		}

		if (validaData == "") {
			alert('Preencha o campo com a data de entrada');
			form1.data.focus();
			return false;
		}

		// Verificar se o formato da data digitada está correto       
		var patternData = /^(\d{2}).(\d{2}).(\d{4}).(\d{2}).(\d{2}).(\d{2})$/;
		if (!patternData.test(validaData)) {
			alert("Digite a data no formato Dia/Mês/Ano");
			form1.dataCadastro.focus();
			return false;
		} else {
			document.getElementById("form1").submit();
		}

	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="/fundos/cota/alterar" method="POST"
		onsubmit='return event.keyCode!=13'>
		<input type="hidden" name="fundo.id" value="${cota.fundo.id}">
		<input type="hidden" name="id" value="${cota.id}">
		Valor: <input name="valor" value="${cota.valor}" autofocus="autofocus" />
			Data: <input name="dataCadastro" value="${cota.data}" /> <br />
			<input type="button" value="Alterar"
			onclick='validar()' />
	</form>
</body>
</html>