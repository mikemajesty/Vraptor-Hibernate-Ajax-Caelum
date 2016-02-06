<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deletar</title>
</head>
<body>
	<form action="confirmar" method="Post">
		<fieldset>
			<legend>Editar Produto</legend>
			<input type="hidden" name="id"
				value="${produto.produtoID }" /> <label for="nome">Nome:</label> <input
				id="nome" type="text" disabled="disabled" value="${produto.nome }" />
			<label for="descricao">Descrição:</label>
			<textarea id="descricao" disabled="disabled">
${produto.descricao }
</textarea>
			<label for="preco">Preço:</label> <input id="preco"
				disabled="disabled" type="text" value="${produto.preco }" />
			<button type="submit">Deletar</button>
		</fieldset>
	</form>
</body>
</html>