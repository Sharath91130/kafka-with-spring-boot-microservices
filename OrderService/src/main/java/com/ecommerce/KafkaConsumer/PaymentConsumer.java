package com.ecommerce.KafkaConsumer;


import com.ecommerce.Dto.PaymentResponse;
import com.ecommerce.KafkaConfig.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    @Autowired
    KafkaProducer produce;
    @KafkaListener(topics = "paymentdone-topic",groupId = "paymentService")
    public void receivePaymentDetails(PaymentResponse PaymentResponse){
    	PaymentResponse.setPaymentId("123");
        System.out.println("details about the payment done");
        System.out.println(PaymentResponse.getPaymentId() + " " + PaymentResponse.getStatus()+ " "+PaymentResponse.getAmount());
    
        produce.sendToInventoryServices(PaymentResponse.getOrderId());
    }
}
