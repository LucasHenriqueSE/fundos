<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>>
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
<body style="font-size: 13px;">
	<form id="form1" name="form1" action="" method="POST"
		onsubmit='return event.keyCode!=13'></form>
	<div class="container">
		<c:choose>
			<c:when test="${cotas != null}">
				<table class="table table-hover table-bordered"
					style="text-align: center;">
					<tr style="font-weight: bold;">
						<td>ID</td>
						<td>VALOR</td>
						<td>DATA</td>
						<td>EDITAR</td>
						<td>EXCLUIR</td>
					</tr>
					<c:forEach var="cota" items="${cotas}">
						<tr>
							<td>${cota.id}</td>
							<td>${cota.valor}</td>
							<td><fmt:formatDate value="${cota.data}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>
							<td><a href="/fundos/cota/${cota.id}/editar"><span
									class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
							<td><a href="/fundos/cota/${cota.id}/deletar"><span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h1>Nenhuma cota Cadastrada</h1>
			</c:otherwise>
		</c:choose>
		<div style="text-align: center;">
			<a class="btn btn-primary" href="/fundos/cota/cadastrar/${idFundo}">Nova
				Cota</a> <a class="btn btn-primary" href="/fundos">Voltar</a>
		</div>
	</div>
</body>
</html>