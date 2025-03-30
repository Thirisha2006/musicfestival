package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    
    public Payment updatePayment(Long id, Payment updatedPayment) {
        if (paymentRepository.existsById(id)) {
            updatedPayment.setId(id);
            return paymentRepository.save(updatedPayment);
        }
        return null;
    }


    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
