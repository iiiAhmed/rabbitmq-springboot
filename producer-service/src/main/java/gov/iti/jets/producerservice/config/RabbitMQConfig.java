package gov.iti.jets.producerservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    Queue orderQueue() {
        return new Queue("order.queue", true);
    }

    @Bean
    Exchange orderExchange() {
        return new DirectExchange("order.exchange");
    }

    @Bean
    Binding orderBinding() {
        return BindingBuilder
                .bind(orderQueue())
                .to((DirectExchange) orderExchange())
                .with("order.routing.key");
    }

}