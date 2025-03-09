package com.project.worker.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentResponseSuccessProducer {

    private final AmqpTemplate amqpTemplate;

    public void integratePaymentResponse(String paymentResponse) {
        amqpTemplate.convertAndSend("payment-response-success-exchange", "payment-response-success-routing-key", paymentResponse);
    }
}
