package com.gabrieldragone.demobackendapi.message.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.gabrieldragone.demobackendapi.dto.PagamentoDTO
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class PagamentoRequestProducer(private val amqpTemplate: AmqpTemplate) {

    private val objectMapper = ObjectMapper()

    fun integrar(pagamentoDTO: PagamentoDTO) {
        amqpTemplate.convertAndSend(
            "pagamento-request-exchange",
            "pagamento-request-rout-key",
            objectMapper.writeValueAsString(pagamentoDTO)
        )
    }

}