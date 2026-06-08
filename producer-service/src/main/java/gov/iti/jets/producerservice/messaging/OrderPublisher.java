package gov.iti.jets.producerservice.messaging;

import gov.iti.jets.producerservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(Order order) {
        rabbitTemplate.convertAndSend("order.exchange", "order.routing.key", order);
    }

}