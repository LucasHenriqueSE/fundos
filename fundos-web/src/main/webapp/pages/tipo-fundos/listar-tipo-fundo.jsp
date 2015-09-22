<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<td>Ações</td>
				</tr>
				<c:forEach var="tipo" items="${tipos}">
					<tr>
						<td>${tipo.id}</td>
						<td>${tipo.nomeTipoFundo}</td>
						<td><a href="/tipo-de-fundo/${tipo.id}/editar">Editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Nenhum tipo Cadastrado</h1>
		</c:otherwise>
	</c:choose>
	<a href="cadastrar">Novo Tipo de Fundo</a>
</body>
</html>