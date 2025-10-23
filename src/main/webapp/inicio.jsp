<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Concessionária</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #e3f2fd, #bbdefb);
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #1976d2;
            color: white;
            text-align: center;
            padding: 1.5rem 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }

        h1 {
            margin: 0;
            font-size: 2rem;
        }

        main {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 4rem;
        }

        .menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1.5rem;
            width: 90%;
            max-width: 800px;
        }

        .card {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
            padding: 2rem;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 14px rgba(0,0,0,0.15);
        }

        .card a {
            display: block;
            text-decoration: none;
            color: #1976d2;
            font-weight: 600;
            font-size: 1.1rem;
            margin-top: 0.5rem;
        }

        footer {
            text-align: center;
            padding: 1.2rem;
            background-color: #1976d2;
            color: white;
            position: fixed;
            width: 100%;
            bottom: 0;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>

<header>
    <h1>🏎️ Sistema de Concessionária</h1>
    <p>Gerenciamento de Clientes, Veículos, Vendas e Pagamentos</p>
</header>

<main>
    <div class="menu">
        <div class="card">
            <h2>Clientes</h2>
            <a href="cliente/lista.jsp">Gerenciar Clientes</a>
        </div>

        <div class="card">
            <h2>Veículos</h2>
            <a href="veiculo/lista.jsp">Gerenciar Veículos</a>
        </div>

        <div class="card">
            <h2>Vendas</h2>
            <a href="venda/lista.jsp">Gerenciar Vendas</a>
        </div>

        <div class="card">
            <h2>Pagamentos</h2>
            <a href="pagamento/lista.jsp">Gerenciar Pagamentos</a>
        </div>
    </div>
</main>

<footer>
    © 2025 - Sistema de Concessionária | Desenvolvido em Java Web (Servlets + JSP + Hibernate)
</footer>

</body>
</html>
