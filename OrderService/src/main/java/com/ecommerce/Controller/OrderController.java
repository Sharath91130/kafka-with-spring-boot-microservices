package com.ecommerce.Controller;

import com.ecommerce.Dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.KafkaConfig.KafkaProducer;

@RestController
@RequestMapping("/producer")
public class OrderController {
	@Autowired
	KafkaProducer produce;
	@PostMapping("/send")
	public ResponseEntity<OrderRequest>  sendDeatailsToIneventory(@RequestBody OrderRequest order){
		System.out.println(order);
		produce.sendPaymentMessage(order.getAmount());
		return ResponseEntity.ok(order);
	}

}
