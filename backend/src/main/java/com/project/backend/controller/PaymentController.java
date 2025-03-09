package com.project.backend.controller;

import com.project.backend.dto.PaymentDTO;
import com.project.backend.facade.PaymentFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentFacade paymentFacade;

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentFacade.processPayment(paymentDTO));
    }
}
