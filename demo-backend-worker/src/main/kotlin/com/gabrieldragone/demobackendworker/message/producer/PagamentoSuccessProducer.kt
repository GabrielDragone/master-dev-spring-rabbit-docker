package com.gabrieldragone.demobackendworker.message.producer

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class PagamentoSuccessProducer(private val amqpTemplate: AmqpTemplate) {

    fun enviarReposta(mensagem: String) {
        println("Mensagem de SUCESSO sendo enviada!")
        amqpTemplate.convertAndSend(
            "pagamento-response-success-exchange",
            "pagamento-response-success-rout-key",
            mensagem
        )
    }

}