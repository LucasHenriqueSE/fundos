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
		var validaTipo = form1.tipo.value;
		if(validaTipo.trim() == ""){
			alert('Selecione um tipo de fundo.');
			return false;
		}
		
		var validaData = form1.dataCadastro.value;
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
	<div class="form-group spam12" style="margin-left: 40%">
		<form id="form1" name="form1" action="/fundos/movimentos/salvar"
			method="POST" onsubmit='return event.keyCode!=13'>
			<input type="hidden" name="fundo.id" value="${idFundo}" />
			<div class="form-group" style="width: 18%;">
				<label for="tipo">Tipo:</label><select id="tipo"
					class="form-control" name="tipoMovimento.id">
					<option selected="selected" value="">Selecione...</option>
					<c:forEach var="tipo" items="${tipos}">
						<option id="tipo" value="${tipo.id}">${tipo.nomeTipoMovimentoFundo}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="valor">Valor: </label><input id="valor"
					class="form-control" type="tel" name="valorMovimentoFundo" value="" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="qtd">Quantidade:</label><input id="qtd"
					class="form-control" name="qtdMovimentoFundo" value="" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="valorCota">Valor Cota:</label><input id="valorCota"
					class="form-control" name="valorCotaMovimentoFundo" value="" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="data">Data:</label><input id="data" class="form-control"
					name="dataCadastro" value="" />
			</div>
			<a class="btn btn-primary" onclick='valida()'>Cadastrar</a> <a
				class="btn btn-primary" href="/fundos/fundo/${idFundo}/movimentos">Cancelar</a>
		</form>
	</div>
</body>
</html>