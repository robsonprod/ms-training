package com.ponto.payment.resources;

import com.ponto.payment.entities.Payment;
import com.ponto.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private PaymentService paymentService;

    @GetMapping(value = "/{userId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long userId, @PathVariable Integer days){
        Payment payment = paymentService.getPaymentWithFeign(userId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long userId, Integer days){
        Payment payment = new Payment("Nome", 200.0, 8);
        return ResponseEntity.ok(payment);
    }

}
