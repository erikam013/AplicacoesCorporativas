<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Concessionária</title>
</head>
<body>
    <h1>Sistema da Concessionária</h1>

    <h2>Cadastros</h2>
    <ul>
        <li><a href="cadastrarCliente.jsp">Cadastrar Cliente</a></li>
        <li><a href="cadastrarFuncionario.jsp">Cadastrar Funcionário</a></li>
        <li><a href="cadastrarVeiculo.jsp">Cadastrar Veículo</a></li>
        <li><a href="cadastrarVenda.jsp">Registrar Venda</a></li>
        <li><a href="cadastrarPagamento.jsp">Registrar Pagamento</a></li>
    </ul>

    <h2>Relatórios</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/relatorio/veiculos">Veículos Disponíveis</a></li>

        <li>
            <form action="${pageContext.request.contextPath}/relatorio/vendasCliente" method="get" style="display:inline;">
                Vendas por Cliente: 
                <input type="number" name="clienteId" placeholder="ID Cliente" required>
                <button type="submit">Gerar</button>
            </form>
        </li>
        <li>
            <form action="${pageContext.request.contextPath}/relatorio/vendasVendedor" method="get" style="display:inline;">
                Vendas por Vendedor: 
                <input type="number" name="vendedorId" placeholder="ID Vendedor" required>
                <button type="submit">Gerar</button>
            </form>
        </li>

        <li><a href="${pageContext.request.contextPath}/relatorio/pagamentos">Pagamentos Pendentes</a></li>
    </ul>
</body>
</html>
