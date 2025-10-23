package br.cefetrj.controller;

import jakarta.servlet.http.HttpServlet;
import br.cefetrj.dao.VendaDAO;
import br.cefetrj.model.Venda;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/VendaServlet")
public class VendaServlet extends HttpServlet {

    private VendaDAO vendaDAO;

    @Override
    public void init() {
        vendaDAO = new VendaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showForm(request, response, null);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteVenda(request, response);
                break;
            default:
                listVendas(request, response);
                break;
        }
    }

    private void listVendas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venda> lista = vendaDAO.findAll();
        request.setAttribute("listaVendas", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("venda-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Venda venda)
            throws ServletException, IOException {
        request.setAttribute("venda", venda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("venda-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Venda venda = vendaDAO.findById(id);
        showForm(request, response, venda);
    }

    private void deleteVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Venda venda = vendaDAO.findById(id);
        if (venda != null) vendaDAO.delete(venda);
        response.sendRedirect("VendaServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        int vendedorId = Integer.parseInt(request.getParameter("vendedorId"));
        int veiculoId = Integer.parseInt(request.getParameter("veiculoId"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        String data = request.getParameter("data");

        Venda venda = new Venda(id, clienteId, vendedorId, veiculoId, valor, data);

        if (id == 0)
            vendaDAO.save(venda);
        else
            vendaDAO.update(venda);

        response.sendRedirect("VendaServlet?action=list");
    }
}
