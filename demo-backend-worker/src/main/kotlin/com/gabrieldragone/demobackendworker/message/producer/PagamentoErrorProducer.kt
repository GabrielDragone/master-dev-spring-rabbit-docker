package com.gabrieldragone.demobackendworker.message.producer

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class PagamentoErrorProducer(private val amqpTemplate: AmqpTemplate) {

    fun enviarReposta(mensagem: String) {
        println("Mensagem de ERRO sendo enviada!")
        amqpTemplate.convertAndSend(
            "pagamento-response-error-exchange",
            "pagamento-response-error-rout-key",
            mensagem
        )
    }

}