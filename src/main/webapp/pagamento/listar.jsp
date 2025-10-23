<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Pagamentos</title>
</head>
<body>
<h1>Pagamentos Registrados</h1>
<a href="formulario.jsp">Novo Pagamento</a>
<br><br>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>ID Venda</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Status</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="pagamento" items="${listaPagamentos}">
        <tr>
            <td>${pagamento.id}</td>
            <td>${pagamento.vendaId}</td>
            <td>${pagamento.valor}</td>
            <td>${pagamento.data}</td>
            <td>${pagamento.status}</td>
            <td>
                <a href="PagamentoServlet?action=editar&id=${pagamento.id}">Editar</a> |
                <a href="PagamentoServlet?action=excluir&id=${pagamento.id}" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
