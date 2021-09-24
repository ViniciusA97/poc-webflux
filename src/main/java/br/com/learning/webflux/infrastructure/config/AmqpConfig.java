package br.com.learning.webflux.infrastructure.config;

import br.com.learning.webflux.util.Constants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Bean
    Queue reativeQueue(){
        return QueueBuilder.durable(Constants.QUEUE).build();
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(Constants.DIRECT_EXCHAGE);
    }

    @Bean
    Binding binding(Queue reativeQueue, DirectExchange directExchange){
        return BindingBuilder.bind(reativeQueue).to(directExchange).with(Constants.ROUNTING_KEY);
    }


}
