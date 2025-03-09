package com.project.backend.consumer;

import com.project.backend.facade.PaymentFacade;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentResponseErrorConsumer {

    private final PaymentFacade paymentFacade;

    @RabbitListener(queues = {"payment-response-error-queue"})
    public void consumePaymentResponseError(String paymentResponse) {
        System.out.println("====================");
        System.out.println("Received payment response error: " + paymentResponse);
        paymentFacade.errorPaymentResponse(paymentResponse);
    }
}
