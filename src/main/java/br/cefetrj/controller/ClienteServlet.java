package br.cefetrj.controller;

import jakarta.servlet.http.HttpServlet;
import br.cefetrj.dao.ClienteDAO;
import br.cefetrj.model.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

    private ClienteDAO clienteDAO;

    @Override
    public void init() throws ServletException {
        clienteDAO = new ClienteDAO();
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
                deleteCliente(request, response);
                break;
            default:
                listClientes(request, response);
                break;
        }
    }

    private void listClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> lista = clienteDAO.findAll();
        request.setAttribute("listaClientes", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Cliente cliente)
            throws ServletException, IOException {
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteDAO.findById(id);
        showForm(request, response, cliente);
    }

    private void deleteCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteDAO.findById(id);
        if (cliente != null) {
            clienteDAO.delete(cliente);
        }
        response.sendRedirect("ClienteServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");

        Cliente cliente = new Cliente(id, nome, cpf, telefone, endereco);

        if (id == 0)
            clienteDAO.save(cliente);
        else
            clienteDAO.update(cliente);

        response.sendRedirect("ClienteServlet?action=list");
    }
}
