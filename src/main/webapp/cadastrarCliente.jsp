<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Cliente</title>
</head>
<body>
    <h2>Cadastrar Cliente</h2>
    <form method="post" action="CadastrarClienteServlet">
        Nome: <input type="text" name="nome" required><br><br>
        CPF: <input type="text" name="cpf" required><br><br>
        Telefone: <input type="text" name="telefone"><br><br>
        Endereço: <input type="text" name="endereco"><br><br>
        <button type="submit">Salvar</button>
    </form>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
