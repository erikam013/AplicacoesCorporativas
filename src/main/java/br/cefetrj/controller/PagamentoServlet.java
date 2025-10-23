package br.cefetrj.controller;

import jakarta.servlet.http.HttpServlet;
import br.cefetrj.dao.PagamentoDAO;
import br.cefetrj.model.Pagamento;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PagamentoServlet")
public class PagamentoServlet extends HttpServlet {

    private PagamentoDAO pagamentoDAO;

    @Override
    public void init() {
        pagamentoDAO = new PagamentoDAO();
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
                deletePagamento(request, response);
                break;
            default:
                listPagamentos(request, response);
                break;
        }
    }

    private void listPagamentos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pagamento> lista = pagamentoDAO.findAll();
        request.setAttribute("listaPagamentos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Pagamento pagamento)
            throws ServletException, IOException {
        request.setAttribute("pagamento", pagamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pagamento pagamento = pagamentoDAO.findById(id);
        showForm(request, response, pagamento);
    }

    private void deletePagamento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pagamento pagamento = pagamentoDAO.findById(id);
        if (pagamento != null) pagamentoDAO.delete(pagamento);
        response.sendRedirect("PagamentoServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        int vendaId = Integer.parseInt(request.getParameter("vendaId"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        String data = request.getParameter("data");
        String status = request.getParameter("status");

        Pagamento pagamento = new Pagamento(id, vendaId, valor, data, status);

        if (id == 0)
            pagamentoDAO.save(pagamento);
        else
            pagamentoDAO.update(pagamento);

        response.sendRedirect("PagamentoServlet?action=list");
    }
}
