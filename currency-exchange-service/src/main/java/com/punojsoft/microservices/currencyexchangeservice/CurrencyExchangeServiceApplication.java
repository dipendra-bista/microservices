package com.punojsoft.microservices.currencyexchangeservice;

import com.punojsoft.microservices.currencyexchangeservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CurrencyExchangeServiceApplication implements CommandLineRunner {
    @Autowired
    private ExchangeRepository exchangeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ExchangeValue> exchangeValueList = new ArrayList<>();

        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setId(10001);
        exchangeValue.setFrom("USD");
        exchangeValue.setTo("INR");
        exchangeValue.setConversionMultiple(BigDecimal.valueOf(65));
        exchangeValue.setPort(0);

        ExchangeValue exchangeValue1 = new ExchangeValue();
        exchangeValue1.setId(10002);
        exchangeValue1.setFrom("EUR");
        exchangeValue1.setTo("INR");
        exchangeValue1.setConversionMultiple(BigDecimal.valueOf(75));
        exchangeValue1.setPort(0);

        ExchangeValue exchangeValue2 = new ExchangeValue();
        exchangeValue2.setId(10003);
        exchangeValue2.setFrom("AUD");
        exchangeValue2.setTo("INR");
        exchangeValue2.setConversionMultiple(BigDecimal.valueOf(25));
        exchangeValue2.setPort(0);

        exchangeValueList.add(exchangeValue);
        exchangeValueList.add(exchangeValue1);
        exchangeValueList.add(exchangeValue2);

        exchangeRepository.saveAll(exchangeValueList);

    }
}
