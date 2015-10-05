<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Fundos - Tipos de Fundos</title>
</head>
<body>
	<c:if test="${excluiu != null}">
		<c:choose>
			<c:when test="${excluiu == true}">
				<div class="alert alert-success" role="alert">Excluido com
					sucesso!</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger" role="alert">N�o � possivel excluir este Tipo de Fundo!</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:choose>
		<c:when test="${tipos != null}">
			<table class="table table-hover table-bordered">
				<tr style="font-weight: bold;">
					<td>ID</td>
					<td>NOME</td>
					<td>EDITAR</td>
					<td>EXCLUIR</td>
				</tr>
				<c:forEach var="tipo" items="${tipos}">
					<tr>
						<td>${tipo.id}</td>
						<td>${tipo.nomeTipoFundo}</td>
						<td><a href="/fundos/tipo-de-fundo/${tipo.id}/editar">Editar</a></td>
						<td><a href="/fundos/tipo-de-fundo/${tipo.id}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Nenhum tipo Cadastrado</h1>
		</c:otherwise>
	</c:choose>
	<a class="btn btn-primary" href="tipo-de-fundo/cadastrar">Novo Tipo de Fundo</a>
	<input class="btn btn-primary" type="button" value="Voltar" />
</body>
</html>