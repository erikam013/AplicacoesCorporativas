<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Vendas por Vendedor</title>
</head>
<body>
    <h2>Relatório de Vendas por Vendedor</h2>

    <form method="get" action="RelatorioVendasVendedorServlet">
        Informe o ID do Vendedor:
        <input type="number" name="vendedorId" required>
        <button type="submit">Gerar Relatório</button>
    </form>

    <c:if test="${not empty vendas}">
        <h3>Vendas do Vendedor ${vendedorNome}</h3>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID Venda</th>
                <th>ID Cliente</th>
                <th>ID Veículo</th>
                <th>Valor</th>
                <th>Data</th>
            </tr>
            <c:forEach var="venda" items="${vendas}">
                <tr>
                    <td>${venda.id}</td>
                    <td>${venda.clienteId}</td>
                    <td>${venda.veiculoId}</td>
                    <td>${venda.valor}</td>
                    <td>${venda.data}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
