package gov.iti.jets.consumerservice.controller;

import gov.iti.jets.consumerservice.listener.OrderListener;
import gov.iti.jets.consumerservice.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderListener orderListener;

    public OrderController(OrderListener orderListener) {
        this.orderListener = orderListener;
    }

    @GetMapping("/messages")
    public List<Order> getMessages() {
        return orderListener.getReceivedOrders();
    }

}
