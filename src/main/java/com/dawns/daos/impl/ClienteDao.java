/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawns.daos.impl;

import com.dawns.daos.ClienteDaoLocal;
import com.dawns.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Will
 */
@Stateless
public class ClienteDao implements ClienteDaoLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> list() {
        try
        {
            Query query = em.createQuery("Select c from Cliente c order by c.codigo asc");
            return query.getResultList();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public void save(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void delete(Long codigo) {
        Cliente cliente= find(codigo);
        em.remove(cliente);
    }

    @Override
    public Cliente find(Long codigo) {
        return em.find(Cliente.class, codigo);
    }
}
