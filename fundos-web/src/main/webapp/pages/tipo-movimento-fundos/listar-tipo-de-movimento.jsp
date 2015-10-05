<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset=UTF-8 />
<title>Sistema Fundos</title>
</head>
<body style="font-family: verdana; font-size: 12px;">
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
				<div style="text-align: center;">
					<table class="table table-hover table-bordered">
						<thead>
							<tr style="font-weight: bold;">
								<td>ID</td>
								<td>NOME</td>
								<td>EDITAR</td>
								<td>EXCLUIR</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tipo" items="${tipos}">
								<tr>
									<td>${tipo.id}</td>
									<td>${tipo.nomeTipoMovimentoFundo}</td>
									<td><a href="/fundos/tipo-movimento/${tipo.id}/editar"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="/fundos/tipo-movimento/${tipo.id}/excluir"><span
											class="glyphicon glyphicon-remove"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<h1>Nenhum Tipo de Movimento Cadastrado</h1>
			</c:otherwise>
		</c:choose>
		<a class="btn btn-primary" href="/fundos/tipo-movimento/cadastrar">Novo
			Tipo de Movimento</a> <input class="btn btn-primary" type="button"
			value="Voltar" />
	</div>
</body>
</html>