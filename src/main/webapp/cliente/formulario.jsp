<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Cliente</title>
</head>
<body>
<h1>${cliente != null ? "Editar Cliente" : "Novo Cliente"}</h1>

<form action="../ClienteServlet" method="post">
    <input type="hidden" name="id" value="${cliente.id}"/>

    <label>Nome:</label><br>
    <input type="text" name="nome" value="${cliente.nome}" required/><br><br>

    <label>CPF:</label><br>
    <input type="text" name="cpf" value="${cliente.cpf}" required/><br><br>

    <label>Telefone:</label><br>
    <input type="text" name="telefone" value="${cliente.telefone}" required/><br><br>

    <label>Endereço:</label><br>
    <input type="text" name="endereco" value="${cliente.endereco}" required/><br><br>

    <input type="submit" value="Salvar"/>
    <a href="listar.jsp">Voltar</a>
</form>
</body>
</html>
