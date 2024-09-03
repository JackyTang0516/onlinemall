package com.hmall.search.mq;

import com.hmall.search.service.ISearchService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListener {

    @Autowired
    private ISearchService searchService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "up.queue"),
            exchange = @Exchange(name = "item.topic", type = ExchangeTypes.TOPIC),
            key = "item.up"
    ))
    public void listenItemUp(Long id){
        searchService.saveItemById(id);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "down.queue"),
            exchange = @Exchange(name = "item.topic", type = ExchangeTypes.TOPIC),
            key = "item.down"
    ))
    public void listenItemDown(Long id){
        searchService.deleteItemById(id);
    }
}
