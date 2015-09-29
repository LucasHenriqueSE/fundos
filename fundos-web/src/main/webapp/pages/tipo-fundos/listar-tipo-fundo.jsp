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
	<c:choose>
		<c:when test="${tipos != null}">
			<table>
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Ação 1</td>
					<td>Ação 2</td>
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
	<a href="tipo-de-fundo/cadastrar">Novo Tipo de Fundo</a>
</body>
</html>