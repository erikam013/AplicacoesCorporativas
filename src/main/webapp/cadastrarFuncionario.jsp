<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Funcionário</title>
</head>
<body>
    <h2>Cadastrar Funcionário</h2>
    <form method="post" action="CadastrarFuncionarioServlet">
        Nome: <input type="text" name="nome" required><br><br>
        Matrícula: <input type="text" name="matricula" required><br><br>
        Telefone: <input type="text" name="telefone"><br><br>
        Email: <input type="email" name="email"><br><br>
        <button type="submit">Salvar</button>
    </form>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
