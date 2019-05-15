/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawns;

import com.dawns.controllers.ClienteController;
import com.dawns.models.Cliente;
import com.dawns.services.ClienteServicio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Will
 */
@Named(value = "clientRestApi")
@RequestScoped
@Path("cliente-servicio")
public class ClientRestApi {
    @Inject
    private ClienteServicio clienteServicio;
    /**
     * Creates a new instance of ClientRestApi
     */
    public ClientRestApi() {
    }
    
    @GET
    @Path("cliente")
    public JsonArray cliente()
    {
        Cliente cliente = new Cliente();
        cliente.setCodigo((long) 15);
        cliente.setNombre("Jose Flores");
        cliente.setDireccion("Av. Amazonas");
        cliente.setTelefono("072545454");
        return ClienteController.clienteJsonArray(cliente);
    }
    
    @GET
    @Path("list-clientes")
    public JsonArray listClientes()
    {
        return ClienteController.generarRespuesta(clienteServicio.obtenerClientes());
    }
    
    @POST
    @Path("crear")
    public void save(Cliente cliente)
    {
        clienteServicio.guardarCliente(cliente);
    }
    
    @POST
    @Path("actualizar/{id}")
    public void update(@PathParam("id") long codigo, Cliente cliente)
    {
        cliente.setCodigo(codigo);
        clienteServicio.actualizarCliente(cliente);
    }
    
    @DELETE
    @Path("borrar/{id}")
    public void update(@PathParam("id") long codigo)
    {
        clienteServicio.borrarCliente(codigo);
    }
}
