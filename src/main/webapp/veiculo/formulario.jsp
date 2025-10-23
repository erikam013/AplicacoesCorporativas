<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Veículo</title>
</head>
<body>
<h1>${veiculo != null ? "Editar Veículo" : "Novo Veículo"}</h1>

<form action="../VeiculoServlet" method="post">
    <input type="hidden" name="id" value="${veiculo.id}"/>

    <label>Modelo:</label><br>
    <input type="text" name="modelo" value="${veiculo.modelo}" required/><br><br>

    <label>Marca:</label><br>
    <input type="text" name="marca" value="${veiculo.marca}" required/><br><br>

    <label>Ano:</label><br>
    <input type="number" name="ano" value="${veiculo.ano}" required/><br><br>

    <label>Preço:</label><br>
    <input type="text" name="preco" value="${veiculo.preco}" required/><br><br>

    <input type="submit" value="Salvar"/>
    <a href="listar.jsp">Voltar</a>
</form>
</body>
</html>
