<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Pagamentos Pendentes</title>
</head>
<body>
    <h2>Relatório de Pagamentos Pendentes</h2>

    <c:if test="${empty pagamentos}">
        <p>Nenhum pagamento pendente encontrado.</p>
    </c:if>

    <c:if test="${not empty pagamentos}">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID Pagamento</th>
                <th>ID Venda</th>
                <th>Valor</th>
                <th>Data</th>
                <th>Status</th>
            </tr>
            <c:forEach var="p" items="${pagamentos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.vendaId}</td>
                    <td>${p.valor}</td>
                    <td>${p.data}</td>
                    <td>${p.status}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <a href="index.jsp">Voltar ao menu</a>
</body>
</html>
