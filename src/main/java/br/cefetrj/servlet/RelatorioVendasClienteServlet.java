package br.cefetrj.servlet;

import br.cefetrj.model.Venda;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/relatorio/vendasCliente")
public class RelatorioVendasClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String clienteIdParam = request.getParameter("clienteId");
        int clienteId = (clienteIdParam != null) ? Integer.parseInt(clienteIdParam) : -1;

        List<Venda> todasVendas = new ArrayList<>();
        todasVendas.add(new Venda(1, 1, 1, 101, 55000, "2023-06-01"));
        todasVendas.add(new Venda(2, 2, 2, 102, 60000, "2023-07-10"));
        todasVendas.add(new Venda(3, 1, 2, 103, 70000, "2023-08-20"));

        List<Venda> vendasCliente = new ArrayList<>();
        for (Venda v : todasVendas) {
            if (v.getClienteId() == clienteId) {
                vendasCliente.add(v);
            }
        }

        request.setAttribute("clienteNome", "Cliente " + clienteId);
        request.setAttribute("vendas", vendasCliente);

        request.getRequestDispatcher("/relatorioVendasCliente.jsp").forward(request, response);
    }
}
