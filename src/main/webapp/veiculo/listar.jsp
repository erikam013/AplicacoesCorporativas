<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Veículos</title>
</head>
<body>
<h1>Veículos Cadastrados</h1>
<a href="formulario.jsp">Novo Veículo</a>
<br><br>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Modelo</th>
        <th>Marca</th>
        <th>Ano</th>
        <th>Preço</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="veiculo" items="${listaVeiculos}">
        <tr>
            <td>${veiculo.id}</td>
            <td>${veiculo.modelo}</td>
            <td>${veiculo.marca}</td>
            <td>${veiculo.ano}</td>
            <td>${veiculo.preco}</td>
            <td>
                <a href="VeiculoServlet?action=editar&id=${veiculo.id}">Editar</a> |
                <a href="VeiculoServlet?action=excluir&id=${veiculo.id}" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
