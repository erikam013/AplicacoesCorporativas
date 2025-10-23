package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int clienteId;
    private int vendedorId;
    private int veiculoId;
    private double valor;
    private String data;

    public Venda() {}

    public Venda(int id, int clienteId, int vendedorId, int veiculoId, double valor, String data) {
        this.id = id;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.veiculoId = veiculoId;
        this.valor = valor;
        this.data = data;
    }

    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public int getVendedorId() { return vendedorId; }
    public int getVeiculoId() { return veiculoId; }
    public double getValor() { return valor; }
    public String getData() { return data; }

    public void setId(int id) { this.id = id; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public void setVendedorId(int vendedorId) { this.vendedorId = vendedorId; }
    public void setVeiculoId(int veiculoId) { this.veiculoId = veiculoId; }
    public void setValor(double valor) { this.valor = valor; }
    public void setData(String data) { this.data = data; }
}
