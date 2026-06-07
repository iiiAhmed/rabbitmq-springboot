package gov.iti.jets.consumerservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = "order.queue")
    public void processMessage(String content) {
        System.out.println("[MY-LOG]: " + content);
    }

}
