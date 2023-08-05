package com.gabrieldragone.demobackendworker.message.consumer

import com.gabrieldragone.demobackendworker.message.producer.PagamentoErrorProducer
import com.gabrieldragone.demobackendworker.message.producer.PagamentoSuccessProducer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class PagamentoRequestConsumer(
    private val pagamentoSuccessProducer: PagamentoSuccessProducer,
    private val pagamentoErrorProducer: PagamentoErrorProducer
) {

    @RabbitListener(
        queues = ["pagamento-request-queue"]
    )
    fun receberMensagem(@Payload message: Message<Any>) {
        println("Mensagem recebida: $message")
        if (Random.nextBoolean()) {
            pagamentoSuccessProducer.enviarReposta("Mensagem de sucesso Pagamento: $message")
        } else {
            pagamentoErrorProducer.enviarReposta("Erro no Pagamento da mensagem: $message")
        }
    }

}