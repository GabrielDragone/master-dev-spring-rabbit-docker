package com.gabrieldragone.demobackendapi.service

import com.gabrieldragone.demobackendapi.dto.PagamentoDTO
import com.gabrieldragone.demobackendapi.message.producer.PagamentoRequestProducer
import org.springframework.stereotype.Service

@Service
class PagamentoService(
    private val pagamentoRequestProducer: PagamentoRequestProducer
) {

    fun solicitarPagamento(payload: PagamentoDTO): String {
        try {
            pagamentoRequestProducer.integrar(payload)
        } catch (e: Exception) {
            return "Houve um erro ao enviar pagamento para integração. Descrição do erro: ${e.message}"
        }
        return "Pagamento no valor de R$${payload.valor} do pedido ${payload.numeroPedido} aguardando confirmacao!"
    }

    fun erroNoPagamento(payload: String) {
        println("Mensagem de ERRO recebida: $payload")
    }

    fun sucessoNoPagamento(payload: String) {
        println("Mensagem de SUCESSO recebida: $payload")
    }

}