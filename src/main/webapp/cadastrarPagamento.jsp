<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Registrar Pagamento</title>
</head>
<body>
    <h2>Registrar Pagamento</h2>
    <form method="post" action="CadastrarPagamentoServlet">
        ID Venda: <input type="number" name="vendaId" required><br><br>
        Valor: <input type="number" step="0.01" name="valor" required><br><br>
        Data: <input type="date" name="data" required><br><br>
        Forma de Pagamento: 
        <select name="formaPagamento">
            <option value="avista">À vista</option>
            <option value="parcelado">Parcelado</option>
            <option value="financiamento">Financiamento</option>
        </select><br><br>
        <button type="submit">Registrar</button>
    </form>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
