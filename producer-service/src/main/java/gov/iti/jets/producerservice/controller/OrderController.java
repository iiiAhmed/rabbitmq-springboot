package gov.iti.jets.producerservice.controller;

import gov.iti.jets.producerservice.messaging.OrderPublisher;
import gov.iti.jets.producerservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    OrderPublisher orderPublisher;

    public OrderController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping
    ResponseEntity<Order> addOrder(@RequestBody Order order) {
        orderPublisher.publishOrder(order);
        return ResponseEntity.ok(order);
    }

}
