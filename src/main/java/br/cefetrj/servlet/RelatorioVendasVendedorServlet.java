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

@WebServlet("/relatorio/vendasVendedor")
public class RelatorioVendasVendedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vendedorIdParam = request.getParameter("vendedorId");
        int vendedorId = (vendedorIdParam != null) ? Integer.parseInt(vendedorIdParam) : -1;

        List<Venda> todasVendas = new ArrayList<>();
        todasVendas.add(new Venda(1, 1, 1, 101, 55000, "2023-06-01"));
        todasVendas.add(new Venda(2, 2, 2, 102, 60000, "2023-07-10"));
        todasVendas.add(new Venda(3, 1, 2, 103, 70000, "2023-08-20"));

        List<Venda> vendasVendedor = new ArrayList<>();
        for (Venda v : todasVendas) {
            if (v.getVendedorId() == vendedorId) {
                vendasVendedor.add(v);
            }
        }

        request.setAttribute("vendedorNome", "Vendedor " + vendedorId);
        request.setAttribute("vendas", vendasVendedor);

        request.getRequestDispatcher("/relatorioVendasVendedor.jsp").forward(request, response);
    }
}
