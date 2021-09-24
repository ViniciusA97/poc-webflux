package br.com.learning.webflux.application.service;

import br.com.learning.webflux.infrastructure.entity.MessageDto;
import br.com.learning.webflux.util.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void senderMessage(){
        rabbitTemplate.convertAndSend(Constants.QUEUE, new MessageDto("Enviando menssagem"));
    }

}
