<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Tipo de Fundo</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nomeTipoFundo.value;
		if (validaNome.trim() == "") {
			alert('Digite um nome valido');
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<div class="form-group spam12" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/tipo-de-fundo/alterar"
			method="POST" onkeypress='return event.keyCode!=13'>
			<input type="hidden" name="id" value="${tipo.id}" />
			<div class="form-group" style="width: 18%;">
				Tipo de Fundo: <input class="form-control" name="nomeTipoFundo"
					value="${tipo.nomeTipoFundo}" autofocus="autofocus" /><br /> <input
					class="btn btn-primary" type="button" value="Alterar"
					onclick='validar()' /> <a class="btn btn-primary"
					href="javascript:window.history.go(-1)">Cancelar</a>
			</div>
		</form>
	</div>
</body>
</html>