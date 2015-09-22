<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset=UTF-8 />
<title>Movimentos - Fundo${movimentos[0].fundo.nome}</title>
<script type="text/javascript">
</script>
</head>
<body>
	<c:if test="${movimentos != null}">
		<table>
			<tr>
				<td>Id</td>
				<td>Valor</td>
				<td>Quantidade</td>
				<td>Valor Cota</td>
				<td>Data</td>
				<td>Ações</td>
			</tr>
			<c:forEach var="movimento" items="${movimentos}">
				<tr>
					<td>${movimento.id}</td>
					<td>${movimento.valorMovimentoFundo}</td>
					<td>${movimento.qtdMovimentoFundo}</td>
					<td>${movimento.valorCotaMovimentoFundo}</td>
					<td><fmt:formatDate type="both" pattern="dd/MM/yyyy HH:mm:ss" dateStyle="short" timeStyle="medium" value="${movimento.dataMovimentoFundo}"/></td>
					<td><a href="/fundos/movimentos/${movimento.fundo.id}/movimento/${movimento.id}">Editar</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<a href="/fundos/movimentos/cadastrar/${idFundo}">Novo Movimento</a>
</body>
</html>