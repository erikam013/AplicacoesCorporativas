<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Clientes</title>
</head>
<body>
<h1>Clientes Cadastrados</h1>
<a href="formulario.jsp">Novo Cliente</a>
<br><br>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>CPF</th>
        <th>Telefone</th>
        <th>Endereço</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="cliente" items="${listaClientes}">
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.telefone}</td>
            <td>${cliente.endereco}</td>
            <td>
                <a href="ClienteServlet?action=editar&id=${cliente.id}">Editar</a> |
                <a href="ClienteServlet?action=excluir&id=${cliente.id}" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
