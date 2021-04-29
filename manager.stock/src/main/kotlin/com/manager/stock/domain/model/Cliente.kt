package com.manager.stock.domain.model

import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 1,


    @field:NotBlank
    @field:Size(max=60)
    var nome: String = "",

    @field:NotBlank
    @field:Email
    @Size(max=255)
    var email: String = "",

    @field:NotBlank
    @field:Size(max=20)
    var telefone: String = "",

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}
