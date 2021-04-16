package com.guilhpupo.demo.controller;

import java.util.List;


import com.guilhpupo.demo.model.Cliente;
import com.guilhpupo.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> index() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente store(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping(path = { "/{id}" })
    public Cliente show(@PathVariable Long id) {
        try {
            return clienteRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }      
    }

    @PutMapping(path = { "/{id}" })
    public Cliente update(@PathVariable Long id, @RequestBody Cliente novoCliente) {
        try {
            Cliente cliente = clienteRepository.findById(id).get();
            cliente.setNome(novoCliente.getNome());
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            return null;
        }      
    }

    @DeleteMapping(path = { "/{id}" })
    public void destroy(@PathVariable Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (Exception e) {
            
        }      
    }

   
}
