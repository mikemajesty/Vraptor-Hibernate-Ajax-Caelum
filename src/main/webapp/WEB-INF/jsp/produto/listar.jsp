<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.devbridge-autocomplete/1.2.24/jquery.autocomplete.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/smoothness/jquery-ui.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.nome }</td>
					<td>${produto.descricao }</td>
					<td>${produto.preco }</td>
					<td><a href="editar-${produto.produtoID}">Editar</a></td>
					<td><a href="deletar-${produto.produtoID}">Deletar</a></td>
					<td><a href="detalhes-${produto.produtoID}">Detalhes</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script type="text/javascript">
	debugger;


	var data = $.get("./buscajson").html();
	debugger;
	$("#busca").autocomplete({
		source : data
	});
</script>
</html>