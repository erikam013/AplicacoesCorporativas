package br.cefetrj.servlet;

import br.cefetrj.model.Pagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/relatorio/pagamentos")
public class RelatorioPagamentosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new Pagamento(1, 1, 20000, "2023-09-01", "Pendente"));
        pagamentos.add(new Pagamento(2, 2, 60000, "2023-07-15", "Pago"));
        pagamentos.add(new Pagamento(3, 3, 35000, "2023-08-30", "Pendente"));

        List<Pagamento> pendentes = new ArrayList<>();
        for (Pagamento p : pagamentos) {
            if ("Pendente".equalsIgnoreCase(p.getStatus())) {
                pendentes.add(p);
            }
        }

        request.setAttribute("pagamentos", pendentes);
        request.getRequestDispatcher("/relatorioPagamentos.jsp").forward(request, response);
    }
}
