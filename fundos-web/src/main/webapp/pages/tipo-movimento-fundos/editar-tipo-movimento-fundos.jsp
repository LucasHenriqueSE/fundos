<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Cadastro Tipo de Movimento Fundos</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nomeTipoMovimentoFundo.value;
		if (validaNome.trim() == "") {
			alert('Informe um nome válido!');
			form1.nomeTipoMovimentoFundo.focus();
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<div class="form-group spam12" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/tipo-movimento/alterar"
			method="POST" onsubmit='return event.keyCode!=13'>
			<input name="id" type="hidden" value="${tipo.id}" />
			<div class="form-group" style="width: 18%;">
				<label for="nome">Nome: </label><input id="nome"
					class="form-control" name="nomeTipoMovimentoFundo"
					value="${tipo.nomeTipoMovimentoFundo}" autofocus="autofocus" />
			</div>
			<input class="btn btn-primary" type="button" value="Alterar"
				onclick='validar()' /> <input class="btn btn-primary" type="button"
				value="Cancelar" />
		</form>
	</div>
</body>
</html>