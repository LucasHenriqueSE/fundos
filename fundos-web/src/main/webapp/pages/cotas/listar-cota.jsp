<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<title>Alterar Cota</title>
<script type="text/javascript">
	function listarCotas() {
		var idFundo = form1.fundo.value;

		window.location = "/fundos/fundo/" + idFundo + "/cotas";
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="" method="POST"
		onsubmit='return event.keyCode!=13'>
		Fundo: <select id="fundo" name="fundo.id" onchange='listarCotas()'>
			<option value="">Selecione...</option>
			<c:forEach var="fundo" items="${fundos}">
				<option value="${fundo.id}">${fundo.nome}</option>
			</c:forEach>
		</select>

	</form>
	<c:if test="${cotas != null}">
		<table>
			<tr>
				<td>Id</td>
				<td>Valor</td>
				<td>Ações</td>
			</tr>
			<c:forEach var="cota" items="${cotas}">
				<tr>
					<td>${cota.id}</td>
					<td>${cota.valor}</td>
					<td><a href="/fundos/cota/editar/${cota.id}">Editar</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>