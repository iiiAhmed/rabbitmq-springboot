package gov.iti.jets.consumerservice.listener;

import gov.iti.jets.consumerservice.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = "order.queue")
    public void processMessage(Order order) {
        System.out.println("[MY-LOG]: Received order: " + order);
    }

}
