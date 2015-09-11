<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="UTF-8" />
<title>Cadastro de Fundos</title>
</head>
<body>
	<form action="/fundos/salvar" method="POST">
		Nome: <input name="nome" value="" /> 
		Tipo: <select name="tipoFundo.id">
				<option value="">Selecione...</option>
					<c:forEach var="tipo" items="${tipos}">
						<option value="${tipo.id}">${tipo.nomeTipoFundo}</option>
					<c:if test="${tipo.nomeTipoFundo == null}">
						<script>alert('Erro no login!!!')</script>					
					</c:if>							
					</c:forEach>
			</select>
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>