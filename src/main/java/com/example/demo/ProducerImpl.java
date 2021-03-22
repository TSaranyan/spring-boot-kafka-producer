package com.example.demo;

import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class ProducerImpl
{
  private final KafkaOperations<Integer, String> kafkaOperations;

  public ProducerImpl(KafkaOperations<Integer, String> kafkaOperations) {
    this.kafkaOperations = kafkaOperations;
  }

  public void sendMail(final String mes) {
    ListenableFuture<SendResult<Integer, String>> future = kafkaOperations.send("mails", mes);

    future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
      @Override
      public void onFailure(Throwable ex) {
        ex.printStackTrace();
      }
      @Override
      public void onSuccess(SendResult<Integer, String> result) {
        System.out.println("Result (success): " + result.getRecordMetadata());
      }
    });
  }
}
