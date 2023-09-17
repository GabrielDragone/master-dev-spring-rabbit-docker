package com.gabrieldragone.demobackendapi.controller

import com.gabrieldragone.demobackendapi.service.RedisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/reservas")
class ReservaController(private val redisService: RedisService) {

    @GetMapping("/cr")
    fun criar(): ResponseEntity<String> {
        val resourceKey = "ABC-12345" // Chave que representa o recurso que você deseja proteger

        try {
            val acquiredLock = redisService.tryLock(resourceKey, 5) // Bloqueia o recurso por 5 minutos
            if (acquiredLock) {
                return ResponseEntity.ok("Recurso protegido acessado com sucesso.")
            } else {
                return ResponseEntity.badRequest().body("Recurso já está em uso.")
            }
        } catch (e: Exception) {
            return ResponseEntity.status(500).body("Erro ao acessar o recurso protegido.")
        } finally {
            // Sempre libere o recurso quando terminar de usá-lo, mesmo em caso de exceção
            //redisService.releaseLock(resourceKey)
        }
    }

    @GetMapping("/rl")
    fun liberar(): String {
        val resourceKey = "ABC-12345"
        redisService.releaseLock(resourceKey)
        return "Recurso liberado com sucesso."
    }
}