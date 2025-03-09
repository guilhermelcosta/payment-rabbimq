package com.project.worker.consumer;

import com.project.worker.producer.PaymentResponseErrorProducer;
import com.project.worker.producer.PaymentResponseSuccessProducer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@AllArgsConstructor
@Component
public class PaymentRequestConsumer {

    private final PaymentResponseSuccessProducer paymentResponseSuccessProducer;
    private final PaymentResponseErrorProducer paymentResponseErrorProducer;

    @RabbitListener(queues = {"payment-request-queue"})
    public void consumePaymentRequest(@Payload Message paymentRequest) {
        if (new Random().nextBoolean()) {
            System.out.println("Payment request processed successfully");
            paymentResponseSuccessProducer.integratePaymentResponse(paymentRequest.getPayload().toString());
        } else {
            System.out.println("Error processing payment request");
            paymentResponseErrorProducer.integratePaymentResponse(paymentRequest.getPayload().toString());
        }
    }
}
