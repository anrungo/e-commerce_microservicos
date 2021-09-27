package br.arungo.ecommerce.checkout.service;

import br.arungo.ecommerce.checkout.entity.CheckoutEntity;
import br.arungo.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

}
