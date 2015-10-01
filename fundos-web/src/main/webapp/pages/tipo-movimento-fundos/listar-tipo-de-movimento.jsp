<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Fundos</title>
</head>
<body>
	<c:if test="${excluiu != null}">
		<c:choose>
			<c:when test="${excluiu == true}">
				<div class="alert alert-success" role="alert">Excluido com
					sucesso!</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger" role="alert">Não é possivel
					excluir este Tipo de Movimento!</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	<div class="container">
		<c:choose>
			<c:when test="${tipos != null}">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nome</td>
							<td>Ação 1</td>
							<td>Ação 2</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tipo" items="${tipos}">
							<tr>
								<td>${tipo.id}</td>
								<td>${tipo.nomeTipoMovimentoFundo}</td>
								<td><a href="/fundos/tipo-movimento/${tipo.id}/editar">Editar</a></td>
								<td><a href="/fundos/tipo-movimento/${tipo.id}/excluir">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1>Nenhum Tipo de Movimento Cadastrado</h1>
			</c:otherwise>
		</c:choose>
		<a href="/fundos/tipo-movimento/cadastrar">Novo Tipo de Movimento</a>
	</div>
</body>
</html>