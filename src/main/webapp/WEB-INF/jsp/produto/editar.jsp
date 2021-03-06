<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar</title>
</head>
<body>
	<form action="editar" method="Post">
		<c:forEach var="error" items="${errors}">
			<div style="background-color: red;">
				${error.category} - ${error.message} <br />
			</div>
		</c:forEach>
		<fieldset>
			<legend>Editar Produto</legend>
			<input type="hidden" name="produto.produtoID"
				value="${produto.produtoID}" /> <label for="nome">Nome:</label> <input
				id="nome" type="text" name="produto.nome" value="${produto.nome}" />
			<label for="descricao">Descrição:</label>
			<textarea id="descricao" name="produto.descricao">
${produto.descricao}
</textarea>
			<label for="preco">Preço:</label> <input id="preco" type="text"
				name="produto.preco" value="${produto.preco}" />
			<button type="submit">Editar</button>
		</fieldset>

	</form>
	<form action="<c:url value="/imagen/${produto.id }/imagem"/>"
		method="POST" enctype="multipart/form-data">
		<fieldset>
			<legend>Upload de Imagem</legend>
			<input type="file" name="imagem" />
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>