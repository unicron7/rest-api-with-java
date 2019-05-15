/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawns.services;

import com.dawns.daos.ClienteDaoLocal;
import com.dawns.models.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Will
 */
@Named(value = "clienteServicio")
@ApplicationScoped
public class ClienteServicio {
    @EJB
    private ClienteDaoLocal clienteDao;
    
    /**
     * Creates a new instance of ClienteServicio
     */
    public ClienteServicio() {
    }
    
    public List<Cliente> obtenerClientes() {
        return clienteDao.list();
    }
    
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
    public void actualizarCliente(Cliente cliente) {
        clienteDao.update(cliente);
    }
    
    public void borrarCliente(Long codigo) {
        clienteDao.delete(codigo);
    }
}
