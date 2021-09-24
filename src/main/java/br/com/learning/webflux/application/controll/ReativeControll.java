package br.com.learning.webflux.application.controll;

import br.com.learning.webflux.application.entity.ResponseDto;
import br.com.learning.webflux.application.service.SenderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static reactor.core.publisher.Mono.*;

@RestController
@RequestMapping("/api/reativo")
@Slf4j
public class ReativeControll {

    @Autowired
    private SenderMessage senderMessage;

    @GetMapping("/{id}")
    public Mono publishMessage(@PathVariable long id) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String format = formatter.format(date);
        senderMessage.senderMessage();

        Mono response = just(new ResponseDto(format));

        log.info("Delay settado {}", id);
        if (id % 2 == 0) {
             response = just(response)
                    .delayElement(Duration.ofSeconds(5))
                    .block();
        }

        log.info("Enviando resposta, {}", id);
        return response;
    }


}
