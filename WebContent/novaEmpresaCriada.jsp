<!-- JavaServer Pages Standard Tag Library serve para adicionar funções de linguagem de programação ao html -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	<!-- Realiza um teste para verificar se existe objeto dentro da variável empresa,
	caso exista retorna a frase com o nome da empresa -->
		<c:if test="${ not empty empresa }">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
	<!-- Realiza um teste para verificar se não existe objeto dentro de empresa,
	caso não exista retorna a frase "Nenhum empresa cadastrada" -->
		<c:if test="${ empty empresa }">
			Nenhuma empresa cadastrada
		</c:if>
	</body>
</html>