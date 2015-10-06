<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8" />
<title>Cadastro de Fundos</title>
<script id="validacaoCampo" type="text/javascript">
	function validar() {
		var validaNome = form1.nome.value;
		var validaTipo = form1.tipoFundo.value;
		if (validaNome.trim() == "") {
			alert('Digite um nome valido');
			return false;
		}
		if (validaTipo == "") {
			alert('Selecione um tipo');
			return false;
		} else {
			document.getElementById("form1").submit();
		}
	}
</script>
</head>
<body>
	<div class="form-group" style="margin-left: 40%;">
		<form id="form1" name="form1" action="/fundos/alterar" method="POST"
			onkeypress='return event.keyCode!=13'>
			<input type="hidden" name="id" value="${fundo.id}" />
			<div class="form-group" style="width: 18%;">
				<label for="nome">Nome:</label><input id="nome" class="form-control"
					name="nome" value="${fundo.nome}" autofocus="autofocus" />
			</div>
			<div class="form-group" style="width: 18%;">
				<label for="tipoFundo">Tipo de Fundo:</label><select id="tipoFundo"
					class="form-control" name="tipoFundo.id">
					<c:forEach var="tipo" items="${tipos}">
						<c:choose>
							<c:when test="${fundo.tipoFundo.id == tipo.id}">
								<option value="${tipo.id}" selected="selected">${tipo.nomeTipoFundo}</option>
							</c:when>
							<c:otherwise>
								<option value="${tipo.id}">${tipo.nomeTipoFundo}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<br /> <input class="btn btn-primary" type="button" value="Alterar"
				onclick='validar()' /> <a class="btn btn-primary"
				href="/fundos">Cancelar</a>
		</form>
	</div>
</body>
</html>