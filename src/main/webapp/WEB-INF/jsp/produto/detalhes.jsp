<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhes</title>
</head>
<body>
	<fieldset>
		<legend>Detalhes Produto</legend>
		<input type="hidden" value="${produto.produtoID }" /> <label
			for="nome">Nome:</label> <input id="nome" type="text"
			disabled="disabled" value="${produto.nome }" /> <label
			for="descricao">Descrição:</label>
		<textarea id="descricao" disabled="disabled">
${produto.descricao }
</textarea>
		<label for="preco">Preço:</label> <input id="preco"
			disabled="disabled" type="text" value="${produto.preco }" />
		<a href="listar">Sair</a>
		<a href="editar?id=${produto.produtoID }">Editar</a>
		<a href="deletar?id=${produto.produtoID }">Deletar</a>
	</fieldset>
</body>
</html>