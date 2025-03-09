package com.project.worker.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentResponseErrorProducer {

    private final AmqpTemplate amqpTemplate;

    public void integratePaymentResponse(String paymentResponse) {
        amqpTemplate.convertAndSend("payment-response-error-exchange", "payment-response-error-routing-key", paymentResponse);
    }
}
