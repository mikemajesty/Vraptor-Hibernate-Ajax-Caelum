
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Compras</title>
</head>
<body>
	<h3>Itens do seu carrinho de compras</h3>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Qtde</th>
				<th>Total</th>
				<th>Remover</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${carrinho.itens }" var="item" varStatus="s">
				<tr>
					<td>${item.produto.id }</td>
					<td>${item.produto.nome }</td>
					<td>${item.produto.descricao }</td>
					<td>
						<fmt:formatNumber type="currency" value="${item.produto.preco }"/>
					</td>
					<td>${item.quantidade }</td>
					<td>
						<fmt:formatNumber type="currency" 
							value="${item.quantidade * item.produto.preco }"/>
					</td>
					<td align="center">
						<form action="<c:url value="/carrinho/${s.index }"/>" method="POST">
							<button class="link" name="_method" value="DELETE">
							<img src="http://postimg.org/image/h0hv72ogh/" />
							</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="3"></th>
				<th colspan="2">Total:</th>
				<th>
					<fmt:formatNumber type="currency" 
						value="${carrinho.total }"/>
				</th>
				<th colspan="1"></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>