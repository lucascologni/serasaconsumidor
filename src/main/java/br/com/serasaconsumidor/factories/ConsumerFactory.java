package br.com.serasaconsumidor.factories;

import br.com.serasaconsumidor.models.Consumer;

public class ConsumerFactory {

    public static Consumer getConsumerWithValidCpf() {

        Consumer consumer = new Consumer();
        consumer.setCpf("87431920091");

        return consumer;
    }

    public static Consumer getConsumerWithInvalidCpf() {

        Consumer consumer = new Consumer();
        consumer.setCpf("48789951547");

        return consumer;
    }
}