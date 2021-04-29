package com.manager.stock.domain.repository

import com.manager.stock.domain.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente,Int> {

    fun findByNome(nome: String): Cliente
    fun findByNomeContaining(nome: String):MutableList<Cliente>


}