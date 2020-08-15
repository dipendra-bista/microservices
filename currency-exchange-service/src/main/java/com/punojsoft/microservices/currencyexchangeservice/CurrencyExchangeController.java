package com.punojsoft.microservices.currencyexchangeservice;

import com.punojsoft.microservices.currencyexchangeservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        System.out.println("From " + from);
        System.out.println("To " + to);

        ExchangeValue exchangeValue = exchangeRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        //        exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
        System.out.println(exchangeValue.getConversionMultiple());
        return exchangeValue;
    }
}
