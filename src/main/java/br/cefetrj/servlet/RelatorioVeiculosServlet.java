package br.cefetrj.servlet;

import br.cefetrj.model.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/relatorio/veiculos")
public class RelatorioVeiculosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Veiculo(1, "ABC-1234", "Fiat", "Argo", 2022, 55000));
        veiculos.add(new Veiculo(2, "XYZ-9876", "Chevrolet", "Onix", 2021, 60000));

        request.setAttribute("veiculos", veiculos);
        request.getRequestDispatcher("/relatorioVeiculos.jsp").forward(request, response);
    }
}
