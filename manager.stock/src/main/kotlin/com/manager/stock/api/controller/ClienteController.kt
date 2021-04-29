package com.manager.stock.api.controller

import com.manager.stock.domain.model.Cliente
import com.manager.stock.domain.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/clientes")
class ClienteController {


    @Autowired
    private lateinit var clienteRepository: ClienteRepository

    @GetMapping
    fun listar(): MutableList<Cliente> {
        return clienteRepository.findAll()
    }

    @GetMapping("/{idCliente}")
    fun buscarCliente(@PathVariable idCliente: Int): ResponseEntity<Cliente> {
        var cliente: Optional<Cliente> = clienteRepository.findById(idCliente)
        if (cliente.isPresent) {
            return ResponseEntity.ok(cliente.get())
        }
        return ResponseEntity.notFound().build()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun inserirCliente(@Valid @RequestBody cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    @PutMapping("/{idCliente}")
    fun atualizarCliente(@Valid @PathVariable idCliente: Int, @RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        if (!clienteRepository.existsById(idCliente)) {
            return ResponseEntity.notFound().build()
        }
        cliente.id = idCliente
        return ResponseEntity.ok(clienteRepository.save(cliente))


    }

    @DeleteMapping("/{idCliente}")
    fun deletarCliente(@PathVariable idCliente: Int): ResponseEntity<Void> {
        if (!clienteRepository.existsById(idCliente)) {
            return ResponseEntity.notFound().build()
        }
        clienteRepository.deleteById(idCliente)
        return ResponseEntity.noContent().build()
    }


}