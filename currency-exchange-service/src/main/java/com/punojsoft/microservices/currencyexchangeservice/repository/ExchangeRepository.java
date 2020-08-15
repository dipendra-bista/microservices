package com.punojsoft.microservices.currencyexchangeservice.repository;

import com.punojsoft.microservices.currencyexchangeservice.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeValue, Integer> {
    ExchangeValue findByFromAndTo(String from, String to);
}
