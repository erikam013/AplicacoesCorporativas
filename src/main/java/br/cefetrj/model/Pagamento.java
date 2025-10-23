package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int vendaId;
    private double valor;
    private String data;
    private String status;

    public Pagamento() {}

    public Pagamento(int id, int vendaId, double valor, String data, String status) {
        this.id = id;
        this.vendaId = vendaId;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public int getId() { return id; }
    public int getVendaId() { return vendaId; }
    public double getValor() { return valor; }
    public String getData() { return data; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setVendaId(int vendaId) { this.vendaId = vendaId; }
    public void setValor(double valor) { this.valor = valor; }
    public void setData(String data) { this.data = data; }
    public void setStatus(String status) { this.status = status; }
}
