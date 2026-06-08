package gov.iti.jets.consumerservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    Queue orderQueue() {
        return new Queue("order.queue", true);
    }

    @Bean
    DirectExchange orderExchange() {
        return new DirectExchange("order.exchange");
    }


    @Bean
    Binding orderBinding() {
        return BindingBuilder
                .bind(orderQueue())
                .to(orderExchange())
                .with("order.routing.key");
    }

    @Bean
    MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}