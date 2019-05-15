/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawns.daos;

import com.dawns.models.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Will
 */
@Local
public interface ClienteDaoLocal {
    List<Cliente> list();
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long codigo);
    Cliente find(Long codigo);
}
