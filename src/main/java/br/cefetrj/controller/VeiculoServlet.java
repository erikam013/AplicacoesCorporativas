package br.cefetrj.controller;

import jakarta.servlet.http.HttpServlet;
import br.cefetrj.dao.VeiculoDAO;
import br.cefetrj.model.Veiculo;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/VeiculoServlet")
public class VeiculoServlet extends HttpServlet {

    private VeiculoDAO veiculoDAO;

    @Override
    public void init() {
        veiculoDAO = new VeiculoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new": showForm(request, response, null); break;
            case "edit": editForm(request, response); break;
            case "delete": deleteVeiculo(request, response); break;
            default: listVeiculos(request, response); break;
        }
    }

    private void listVeiculos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Veiculo> lista = veiculoDAO.findAll();
        request.setAttribute("listaVeiculos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Veiculo veiculo)
            throws ServletException, IOException {
        request.setAttribute("veiculo", veiculo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("veiculo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Veiculo veiculo = veiculoDAO.findById(id);
        showForm(request, response, veiculo);
    }

    private void deleteVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Veiculo veiculo = veiculoDAO.findById(id);
        if (veiculo != null) veiculoDAO.delete(veiculo);
        response.sendRedirect("VeiculoServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        String placa = request.getParameter("placa");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int ano = Integer.parseInt(request.getParameter("ano"));
        double preco = Double.parseDouble(request.getParameter("preco"));

        Veiculo veiculo = new Veiculo(id, placa, marca, modelo, ano, preco);

        if (id == 0) veiculoDAO.save(veiculo);
        else veiculoDAO.update(veiculo);

        response.sendRedirect("VeiculoServlet?action=list");
    }
}
