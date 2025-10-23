<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Vendas</title>
</head>
<body>
<h1>Vendas Registradas</h1>
<a href="formulario.jsp">Nova Venda</a>
<br><br>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>ID Cliente</th>
        <th>ID Vendedor</th>
        <th>ID Veículo</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="venda" items="${listaVendas}">
        <tr>
            <td>${venda.id}</td>
            <td>${venda.clienteId}</td>
            <td>${venda.vendedorId}</td>
            <td>${venda.veiculoId}</td>
            <td>${venda.valor}</td>
            <td>${venda.data}</td>
            <td>
                <a href="VendaServlet?action=editar&id=${venda.id}">Editar</a> |
                <a href="VendaServlet?action=excluir&id=${venda.id}" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
