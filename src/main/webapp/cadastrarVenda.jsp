<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Registrar Venda</title>
</head>
<body>
    <h2>Registrar Venda</h2>
    <form method="post" action="CadastrarVendaServlet">
        ID Cliente: <input type="number" name="clienteId" required><br><br>
        ID Funcionário: <input type="number" name="funcionarioId" required><br><br>
        ID Veículo: <input type="number" name="veiculoId" required><br><br>
        Valor: <input type="number" step="0.01" name="valor" required><br><br>
        Data: <input type="date" name="data" required><br><br>
        <button type="submit">Registrar</button>
    </form>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
