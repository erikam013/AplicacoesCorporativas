package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Veiculo() {}

    public Veiculo(int id, String placa, String marca, String modelo, int ano, double preco) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getPreco() { return preco; }

    public void setId(int id) { this.id = id; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAno(int ano) { this.ano = ano; }
    public void setPreco(double preco) { this.preco = preco; }
}
