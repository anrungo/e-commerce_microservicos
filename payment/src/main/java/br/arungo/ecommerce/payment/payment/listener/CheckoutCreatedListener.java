package br.arungo.ecommerce.payment.payment.listener;

import br.arungo.ecommerce.payment.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedListener event){
        // Processo pagamento gateway
        // salvar os dados de pagamento
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setCheckoutStatus(event.getStatus())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload().build());

    }
}
