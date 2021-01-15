<%@page import="servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JavaServer Pages Standard Tag Library serve para adicionar funções de linguagem de programação ao html -->
<!-- Para que o JSTL funcione é necessário adicionar o jar no diretório /WEB-INF/lib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${ not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>

	Lista de empresas: <br />
	<ul>
	<!-- Percorre todos elementos da lista de empresas -->
		<c:forEach items="${empresas}" var="empresa">
		<!-- Usa o fmt para formatar a data de abertura de conta com o formato dd/MM/yyyy, ex: 10/04/1999 -->
			<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/removeEmpresa?id=${ empresa.id }">remove</a>
				<a href="/gerenciador/mostraEmpresa?id=${empresa.id}">edita</a>			
			</li>
		</c:forEach>
	</ul>
</body>
</html>