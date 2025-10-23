package br.cefetrj.dao;

import br.cefetrj.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
    public ClienteDAO() {
        super(Cliente.class);
    }
}
