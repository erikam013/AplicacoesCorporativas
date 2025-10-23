<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Veículos Disponíveis</title>
</head>
<body>
    <h2>Relatório de Veículos Disponíveis</h2>

    <c:if test="${empty veiculos}">
        <p>Nenhum veículo disponível.</p>
    </c:if>

    <c:if test="${not empty veiculos}">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Placa</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Ano</th>
                <th>Preço</th>
            </tr>
            <c:forEach var="v" items="${veiculos}">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.placa}</td>
                    <td>${v.marca}</td>
                    <td>${v.modelo}</td>
                    <td>${v.ano}</td>
                    <td>${v.preco}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
