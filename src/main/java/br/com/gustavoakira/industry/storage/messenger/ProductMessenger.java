package br.com.gustavoakira.industry.storage.messenger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductMessenger {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String data){
        kafkaTemplate.send(topic,data);
    }

    public String transformToData(Object o){
        String result = "";
        try {
            result= mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
