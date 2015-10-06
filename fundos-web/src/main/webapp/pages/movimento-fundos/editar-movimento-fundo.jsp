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
		if (validaData == "") {
			alert('Preencha o campo com a data de entrada');
			form1.data.focus();
			return false;
		}
		var validaData = form1.dataCadastro.value;
		var patternData = /^(\d{2}).(\d{2}).(\d{4}).(\d{2}).(\d{2}).(\d{2})$/;
		if (validaData == "" || !patternData.test(validaData)) {
			alert("Digite a data no formato Dia/Mês/Ano");
			form1.data.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="form-group spam12" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/movimentos/alterar"
			method="POST" onsubmit='return event.keyCode!=13'>
			<div>
				<input type="hidden" name="id" value="${movimentoFundo.id}" />
			</div>
			<div>
				<input type="hidden" name="fundo.id"
					value="${movimentoFundo.fundo.id}" />
			</div>
			<div>
				<input type="hidden" name="tipoMovimento.id"
					value="${movimentoFundo.tipoMovimento.id}" />
			</div>
			<div class="form-group">
				<label for="tipo">Tipo:</label><select class="form-control"
					style="width: 18%;" id="tipo" name="tipoMovimento.id">
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
				</select>
			</div>
			<div class="form-group">
				<label for="valor">Valor:</label><input id="valor" type="tel"
					class="form-control" style="width: 18%;" name="valorMovimentoFundo"
					value="${movimentoFundo.valorMovimentoFundo}" />
			</div>
			<div class="form-group">
				<label for="qtd">Quatidade:</label><input id="qtd"
					class="form-control" style="width: 18%;" name="qtdMovimentoFundo"
					value="${movimentoFundo.qtdMovimentoFundo}" />
			</div>
			<div class="form-group">
				<label for="vlrCota">Valor Cota:</label><input id="vlrCota"
					class="form-control" style="width: 18%;"
					name="valorCotaMovimentoFundo"
					value="${movimentoFundo.valorCotaMovimentoFundo}" />
			</div>
			<div class="form-group">
				<label for="data">Data:</label><input id="data" class="form-control"
					style="width: 18%;" name="dataCadastro"
					value="${movimentoFundo.dataMovimentoFundo}" />
			</div>
			<input class="btn btn-primary" type="submit" value="Alterar"
				onclick='valida()' /> <a class="btn btn-primary"
				href="/fundos/fundo/${movimentoFundo.fundo.id}/movimentos">Cancelar</a>
		</form>
	</div>
</body>
</html>