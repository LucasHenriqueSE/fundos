<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Fundos</title>
</head>
<body style="font-family: verdana; font-size: 13px;">
	<c:if test="${excluiu != null}">
		<c:choose>
			<c:when test="${excluiu == true}">
				<div class="alert alert-success" role="alert">
					<button class="close" data-dismiss="alert" aria-hidden="tue">&times;</button>
					Excluido com sucesso!
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					Não é possivel excluir este Fundo!
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	<div class="container">
		<c:choose>
			<c:when test="${fundos != null}">
				<table class="table table-hover table-bordered"
					style="text-align: center;">
					<thead>
						<tr style="font-weight: bold;">
							<td>ID</td>
							<td>NOME</td>
							<td>TIPO</td>
							<td>COTAS</td>
							<td>MOVIMENTOS</td>
							<td>EDITAR</td>
							<td>EXCLUIR</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fundo" items="${fundos}">
							<tr>
								<td>${fundo.id}</td>
								<td>${fundo.nome}</td>
								<td>${fundo.tipoFundo.nomeTipoFundo}</td>
								<td><a href="fundo/${fundo.id}/cotas"><span
										class="glyphicon glyphicon-tags" aria-hidden="true"></span></a></td>
								<td><a href="fundo/${fundo.id}/movimentos"><span
										class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a></td>
								<td><a href="fundo/${fundo.id}/editar"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
								<td><a href="fundo/${fundo.id}/excluir"><span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1>Nenhum Fundo Cadastrado</h1>
			</c:otherwise>
		</c:choose>
		<br>
		<div style="text-align: center;">
			<a href="cadastrar" class="btn btn-primary">Cadastrar</a> <a
				href="tipo-de-fundo" class="btn btn-primary" role="button">Tipos
				de Fundo</a> <a href="tipo-movimento" class="btn btn-primary"
				role="button">Tipos de Movimento</a>
		</div>
	</div>
</body>
</html>