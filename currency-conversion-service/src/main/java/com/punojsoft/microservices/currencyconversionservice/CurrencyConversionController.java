package com.punojsoft.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> uriVaraibles = new HashMap<>();
        uriVaraibles.put("from", from);
        uriVaraibles.put("to", to);

        ResponseEntity<CurrencyConversionBean> response = new RestTemplate().
                getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionBean.class
                        , uriVaraibles);
        CurrencyConversionBean currencyConversionBean = response.getBody();

        return new CurrencyConversionBean(1,
                from,
                to,
                currencyConversionBean.getConversionMultiple(),
                quantity,
                quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
    }

    @GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);
        return new CurrencyConversionBean(1,
                from,
                to,
                currencyConversionBean.getConversionMultiple(),
                quantity,
                quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
    }
}
