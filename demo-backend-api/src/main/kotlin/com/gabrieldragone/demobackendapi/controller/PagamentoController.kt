package com.gabrieldragone.demobackendapi.controller

import com.gabrieldragone.demobackendapi.dto.PagamentoDTO
import com.gabrieldragone.demobackendapi.service.PagamentoService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/pagamentos")
class PagamentoController(
    private val pagamentoService: PagamentoService
) {

    @PostMapping
    fun processar(@RequestBody payload: PagamentoDTO): String {
        return pagamentoService.solicitarPagamento(payload)
    }

}
