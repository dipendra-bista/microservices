package com.punojsoft.microservices.limitsservices.limitsservice;

import com.punojsoft.microservices.limitsservices.limitsservice.bean.LimitsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @GetMapping("/limis")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        return new LimitsConfiguration(1, 1000);
    }
}
