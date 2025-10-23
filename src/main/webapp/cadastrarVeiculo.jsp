<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Veículo</title>
</head>
<body>
    <h2>Cadastrar Veículo</h2>
    <form method="post" action="CadastrarVeiculoServlet">
        Placa: <input type="text" name="placa" required><br><br>
        Marca: <input type="text" name="marca" required><br><br>
        Modelo: <input type="text" name="modelo" required><br><br>
        Ano: <input type="number" name="ano" required><br><br>
        Preço: <input type="number" step="0.01" name="preco" required><br><br>
        <button type="submit">Salvar</button>
    </form>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
