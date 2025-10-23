<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Pagamento</title>
</head>
<body>
<h1>${pagamento != null ? "Editar Pagamento" : "Novo Pagamento"}</h1>

<form action="../PagamentoServlet" method="post">
    <input type="hidden" name="id" value="${pagamento.id}"/>

    <label>ID da Venda:</label><br>
    <input type="number" name="vendaId" value="${pagamento.vendaId}" required/><br><br>

    <label>Valor:</label><br>
    <input type="text" name="valor" value="${pagamento.valor}" required/><br><br>

    <label>Data:</label><br>
    <input type="date" name="data" value="${pagamento.data}" required/><br><br>

    <label>Status:</label><br>
    <select name="status">
        <option value="Pendente" ${pagamento.status == 'Pendente' ? 'selected' : ''}>Pendente</option>
        <option value="Pago" ${pagamento.status == 'Pago' ? 'selected' : ''}>Pago</option>
        <option value="Cancelado" ${pagamento.status == 'Cancelado' ? 'selected' : ''}>Cancelado</option>
    </select><br><br>

    <input type="submit" value="Salvar"/>
    <a href="listar.jsp">Voltar</a>
</form>
</body>
</html>
