package com.gabrieldragone.demobackendapi.message.consumer

import org.springframework.stereotype.Component
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import com.gabrieldragone.demobackendapi.service.PagamentoService

@Component
class PagamentoResponseErrorConsumer(
    private val pagamentoService: PagamentoService
) {

    @RabbitListener(
        queues = ["pagamento-response-error-queue"]
    )
    fun receberMensagem(@Payload message: String) {
        pagamentoService.erroNoPagamento(message)
    }

}