<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar</title>
</head>
<body>

	<form action="novo" method="Post" id="novoForm">
		<c:forEach var="error" items="${errors}">
			<div style="background-color: red;">
				${error.category} - ${error.message} <br />
			</div>
		</c:forEach>
		<fieldset>
			<legend>Adicionar Produto</legend>
			<label for="nome"> Nome:</label> <br> <input id="nome"
				type="text" name="produto.nome" value="${produto.nome}" /> <br>
			<label for="descricao">Descrição:</label> <br>
			<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
			<br> <label for="preco">Preço:</label> <br> <input
				id="preco" type="text" name="produto.preco" value="${produto.preco}" />
			<br>
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
<script type="text/javascript">
	$('#novoForm').validate({
		rules : {
			"produto.nome" : {
				required : true,
				minlength : 3
			},
			"produto.descricao" : {
				required : true,
				maxlength : 40
			},
			"produto.preco" : {
				min : 0.0,
				required : true
			}
		}
	});
</script>
</html>