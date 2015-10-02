<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		var patternData = /^(\d{2}).(\d{2}).(\d{4}).(\d{2}).(\d{2}).(\d{2})$/;
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
		<div class="input-group">
			Valor: <input name="valor" value="" autofocus="autofocus" />
		</div>
		<br>
		<div class="input-group">
			Data: <input name="data" value="" />
		</div>
		<br>
		<div class="input-group">
			Fundo: <select id="fundo" name="fundo.id">
					<c:forEach var="fundo" items="${fundos}">
						<option value="${fundo.id}">${fundo.id}</option>
					</c:forEach>
			</select>
		</div>
		<br /> <input type="button" value="Cadastrar" onclick='validar()' />
	</form>
</body>
</html>