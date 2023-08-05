package com.gabrieldragone.demobackendapi.message.consumer

import com.gabrieldragone.demobackendapi.service.PagamentoService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PagamentoResponseSuccessConsumer(
    private val pagamentoService: PagamentoService
) {

    @RabbitListener(
        queues = ["pagamento-response-success-queue"]
    )
    fun receberMensagem(@Payload message: String) {
        pagamentoService.sucessoNoPagamento(message)
    }

}