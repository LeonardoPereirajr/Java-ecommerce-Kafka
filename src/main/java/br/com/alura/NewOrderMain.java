package br.com.alura;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (var dispatcher = new KafkaDispatcher()) {

            for (var i = 0; i < 10; i++) {

                var key = UUID.randomUUID().toString();
                var value = key + ", 675243, 78945894745";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

                var email = "Thank you for your order!";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

