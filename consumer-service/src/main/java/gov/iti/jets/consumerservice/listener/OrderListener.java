package gov.iti.jets.consumerservice.listener;

import gov.iti.jets.consumerservice.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class OrderListener {

    private final List<Order> receivedOrders = new CopyOnWriteArrayList<>();

    @RabbitListener(queues = "order.queue")
    public void processMessage(Order order) {
        System.out.println("[MY-LOG]: Received order: " + order);
        receivedOrders.add(order);
    }

    public List<Order> getReceivedOrders() {
        return receivedOrders;
    }

}
