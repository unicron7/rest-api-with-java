/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawns.controllers;

import com.dawns.models.Cliente;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author Will
 */
public class ClienteController {
    
    public static JsonArray clienteJsonArray(Cliente cliente)
    {
        return Json.createArrayBuilder().add(clienteJsonObject(cliente)).build();
    }
    
    public static JsonObject clienteJsonObject(Cliente cliente)
    {
        return Json.createObjectBuilder().
                add("codigo", cliente.getCodigo()).
                add("nombre", cliente.getNombre()).
                add("direccion", cliente.getDireccion()).
                add("telefono", cliente.getTelefono()).
                build();
    }
    
    public static JsonArray generarRespuesta(List<Cliente> clientes)
    {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Cliente cliente : clientes) {
            builder.add(clienteJsonObject(cliente));
        }
        return builder.build();
    }
}
