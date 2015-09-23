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
		onsubmit='return event.keyCode!=13'></form>
	<c:choose>
		<c:when test="${cotas != null}">
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
						<td><a href="/fundos/cota/${cota.id}/editar">Editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Nenhuma cota Cadastrada</h1>
		</c:otherwise>
	</c:choose>
	<a href="cota/cadastrar">Cadastrar nova Cota</a>
</body>
</html>