package com.punojsoft.microservices.currencyconversionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @GetMapping("corrency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, BigDecimal quantity) {
        return new CurrencyConversionBean(1, from, to, BigDecimal.ONE, quantity, quantity, 0);
    }
}
