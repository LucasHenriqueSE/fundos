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
	<div class="form-group" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/tipo-movimento/salvar"
			method="POST" onsubmit='return event.keyCode!=13'>
			<div class="form-group" style="width: 18%;">
				<label for="nome">Nome:</label><input id="nome" class="form-control"
					name="nomeTipoMovimentoFundo" value="" autofocus="autofocus" />
			</div>
			<input class="btn btn-primary" type="button" value="Cadastrar"
				onclick='validar()' /> <a class="btn btn-primary"
				href="/fundos/tipo-movimento">Cancelar</a>
		</form>
	</div>
</body>
</html>