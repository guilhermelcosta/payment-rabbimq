package com.project.backend.facade;

import com.project.backend.producer.PaymentRequestProducer;
import com.project.backend.dto.PaymentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentFacade {

    private final PaymentRequestProducer paymentRequestProducer;

    public String processPayment(PaymentDTO paymentDTO) {
        paymentRequestProducer.integratePaymentRequest(paymentDTO);
        return "Payment being processed...";
    }

    public void errorPaymentResponse(String paymentResponse) {
        System.out.println("Payment processing failed: " + paymentResponse);
    }

    public void successPaymentResponse(String paymentResponse) {
        System.out.println("Payment processing successful: " + paymentResponse);
    }
}
