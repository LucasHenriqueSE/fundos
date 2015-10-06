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
	<div class="form-group spam12" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/cota/salvar" method="POST"
			onsubmit='return event.keyCode!=13'>
			<div class="form-group" style="width: 18%;">
				<label for="valor">Valor:</label><input id="valor"
					class="form-control" name="valor" value="" autofocus="autofocus" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="data">Data:</label><input id="data" class="form-control"
					name="data" value="" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="fundo">Fundo:</label><select id="fundo"
					class="form-control" name="fundo.id">
					<c:forEach var="fundo" items="${fundos}">
						<option value="${fundo.id}">${fundo.id}</option>
					</c:forEach>
				</select>
			</div>
			<input class="btn btn-primary" type="submit" value="Cadastrar"
				onclick='validar()' /> <a class="btn btn-primary"
				href="/fundos/fundo/${idFundo}/cotas">Cancelar</a>
		</form>
	</div>
</body>
</html>