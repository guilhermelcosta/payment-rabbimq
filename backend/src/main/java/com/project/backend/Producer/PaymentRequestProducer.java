package com.project.backend.Producer;

import com.project.backend.dto.PaymentDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentRequestProducer {

    private final AmqpTemplate amqpTemplate;

    public void integratePaymentRequest(PaymentDTO paymentRequest) {
        amqpTemplate.convertAndSend("payment-request-exchange", "payment-request-routing-key", paymentRequest.toString());
    }
}
