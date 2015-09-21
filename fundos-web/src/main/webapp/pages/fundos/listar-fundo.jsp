<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Fundos</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${fundos != null}">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nome</td>
							<td>Tipo</td>
							<td>Ação 1</td>
							<td>Ação 2</td>
							<td>Ação 3</td>
							<td>Ação 4</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fundo" items="${fundos}">
							<tr>
								<td>${fundo.id}</td>
								<td>${fundo.nome}</td>
								<td>${fundo.tipoFundo.nomeTipoFundo}</td>
								<td><a href="fundo/${fundo.id}/cotas">Cotas</a></td>
								<td><a href="fundo/${fundo.id}/movimentos">Movimentos</a></td>
								<td><a href="fundo/${fundo.id}/editar">Editar</a></td>
								<td><a href="fundo/${fundo.id}/excluir">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1>Nenhum Fundo Cadastrado</h1>
			</c:otherwise>
		</c:choose>
		<a href="cadastrar" class="btn btn-primary" role="button">Novo Fundo</a>
		<a href="tipo-de-fundo" class="btn btn-primary" role="button">Tipos de Fundo</a>
		<a href="tipo-de-movimento" class="btn btn-primary" role="button">Tipos de Movimento</a>
	</div>
</body>
</html>