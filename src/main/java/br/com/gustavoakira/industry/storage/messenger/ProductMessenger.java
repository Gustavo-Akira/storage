package br.com.gustavoakira.industry.storage.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class ProductMessenger {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic,String data){
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(topic,data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Unable to send message=["
                        + data + "] due to : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                System.out.println("Sent message=[" + data + "] with offset=[" + stringStringSendResult.getRecordMetadata().offset() + "]");
            }
        });
    }

}
