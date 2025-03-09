package com.project.backend.consumer;

import com.project.backend.facade.PaymentFacade;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentResponseSuccessConsumer {

    private final PaymentFacade paymentFacade;

    @RabbitListener(queues = {"payment-response-success-queue"})
    public void consumePaymentResponseSuccess(String paymentResponse) {
        System.out.println("====================");
        System.out.println("Received payment response success: " + paymentResponse);
        paymentFacade.successPaymentResponse(paymentResponse);
    }
}
