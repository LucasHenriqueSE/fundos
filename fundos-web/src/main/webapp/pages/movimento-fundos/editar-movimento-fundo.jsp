<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset=UTF-8>
<title>Novo Movimento Fundo</title>
<script id="validacaoCampo" type="text/javascript">
	function valida() {
		var validaValor = form1.valorMovimentoFundo.value;
		if (validaValor.trim() == "") {
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
		} else {
			document.getElementById("form1").submit();
		}
		// 		if (validaData == "") {
		// 			alert('Preencha o campo com a data de entrada');
		// 			form1.data.focus();
		// 			return false;
		// 		}
		// 		var validaData = form1.dataCadastro.value;
		// 		var patternData = /^(\d{2}).(\d{2}).(\d{4}).(\d{2}).(\d{2}).(\d{2})$/;
		// 		if (validaData == "" || !patternData.test(validaData)) {
		// 			alert("Digite a data no formato Dia/Mês/Ano");
		// 			form1.data.focus();
		// 			return false;
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="/fundos/movimentos/alterar"
		method="POST" onsubmit='return event.keyCode!=13'>
		<input type="hidden" name="id" value="${movimentoFundo.id}" /> <input
			type="hidden" name="fundo.id" value="${movimentoFundo.fundo.id}" />
		<input type="hidden" name="tipoMovimento.id"
			value="${movimentoFundo.tipoMovimento.id}" /> Valor: <input
			type="tel" name="valorMovimentoFundo"
			value="${movimentoFundo.valorMovimentoFundo}" /> Quantidade: <input
			name="qtdMovimentoFundo" value="${movimentoFundo.qtdMovimentoFundo}" />
		Valor Cota: <input name="valorCotaMovimentoFundo"
			value="${movimentoFundo.valorCotaMovimentoFundo}" /><br /> Data: <input
			name="dataCadastro" value="${movimentoFundo.dataMovimentoFundo}" />
		Tipo: <select id="tipo" name="tipoMovimento.id">
			<c:forEach var="tipo" items="${tipos}">
				<c:choose>
					<c:when test="${movimentoFundo.tipoMovimento.id == tipo.id}">
						<option value="${tipo.id}" selected="selected">${tipo.nomeTipoMovimentoFundo}</option>
					</c:when>
					<c:otherwise>
						<option value="${tipo.id}">${tipo.nomeTipoMovimentoFundo}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br> <input type="submit" value="Alterar" onclick='valida()' />
	</form>
</body>
</html>