<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset=UTF-8>
<title>Novo Movimento Fundo</title>
<script id="validacaoCampo" type="text/javascript">
	function valida() {
		var validaData = form1.dataCadastro.value;
		var validaValor = form1.valorMovimentoFundo.value;
		if (validaValor.trim() == "" ) {
			alert('Informe o valor do movimento.');
			return false;
		}
		var validaQtd = form1.qtdMovimentoFundo.value;
		if (validaQtd.trim() == "") {
			alert('Informe a quantidade.');
			return false;
		}
		var validaCota = form1.valorCotaMovimentoFundo.value;
		if (validaCota.trim() == "") {
			alert('Informe o valor da cota');
			return false;
		}
		if (validaData == "") {
			alert('Preencha o campo com a data de entrada');
			form1.data.focus();
			return false;
		}
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
	<form id="form1" name="form1" action="/fundos/movimentos/salvar"
		method="POST" onsubmit='return event.keyCode!=13'>
		<input type="hidden" name="fundo.id" value="${idFundo}"/>
		Tipo: <select id="tipo" name="tipoMovimento.id">
				<option selected="selected">Selecione...</option>
				<c:forEach var="tipo" items="${tipos}">
					<option id="tipo" value="${tipo.id}">${tipo.nomeTipoMovimentoFundo}</option>
				</c:forEach>
		</select>
		Valor: <input type="tel" name="valorMovimentoFundo" value="" />
			Quantidade: <input name="qtdMovimentoFundo" value="" />
			Valor Cota: <input name="valorCotaMovimentoFundo" value="" /><br />
			Data: <input name="dataCadastro" value="" /><br /> <input type="submit"
			value="Cadastrar" onclick='valida()' />
	</form>
</body>
</html>