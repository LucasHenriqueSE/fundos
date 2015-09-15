<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8>
<title>Cadastro de Cotas</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaValor = form1.valor.value;
		var validaFundo = form1.fundo.value
		var validaData = form1.data.value;
		if (validaValor.trim() == "") {
			alert('Informe o valor da cota');
			return false;
		}

		if (validaData == "") {
			alert('Preencha o campo com a data de entrada');
			form1.data.focus();
			return false;
		}

		if (validaFundo == "") {
			alert('Selecione um fundo');
			return false;
		}

		// Verificar se o formato da data digitada está correto       
		var patternData = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;
		if (!patternData.test(validaData)) {
			alert("Digite a data no formato Dia/Mês/Ano");
			form1.data.focus();
			return false;
		} else {
			document.getElementById("form1").submit();
		}

	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="salvar" method="POST"
		onsubmit='return event.keyCode!=13'>

		Valor: <input name="valor" value="" autofocus="autofocus" /> Data: <input
			name="data" value="" /> Fundo: <select id="fundo" name="fundo.id">
			<option value="">Selecione...</option>
			<c:forEach var="fundo" items="${fundos}">
				<option value="${fundo.id}">${fundo.nome}</option>
			</c:forEach>
		</select><br /> <input type="button" value="Cadastrar" onclick='validar()' />
	</form>
</body>
</html>