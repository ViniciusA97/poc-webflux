package br.com.learning.webflux.infrastructure.listner;

import br.com.learning.webflux.infrastructure.entity.MessageDto;
import br.com.learning.webflux.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReativeQueueListner {

    @RabbitListener(queues = Constants.QUEUE)
    public void listnerReativeQueue(MessageDto messageDto){
        log.info("Mensagem chegada:  "+messageDto.getMessage());
    }

}
