<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Venda</title>
</head>
<body>
<h1>${venda != null ? "Editar Venda" : "Nova Venda"}</h1>

<form action="../VendaServlet" method="post">
    <input type="hidden" name="id" value="${venda.id}"/>

    <label>ID Cliente:</label><br>
    <input type="number" name="clienteId" value="${venda.clienteId}" required/><br><br>

    <label>ID Vendedor:</label><br>
    <input type="number" name="vendedorId" value="${venda.vendedorId}" required/><br><br>

    <label>ID Veículo:</label><br>
    <input type="number" name="veiculoId" value="${venda.veiculoId}" required/><br><br>

    <label>Valor:</label><br>
    <input type="text" name="valor" value="${venda.valor}" required/><br><br>

    <label>Data:</label><br>
    <input type="date" name="data" value="${venda.data}" required/><br><br>

    <input type="submit" value="Salvar"/>
    <a href="listar.jsp">Voltar</a>
</form>
</body>
</html>
