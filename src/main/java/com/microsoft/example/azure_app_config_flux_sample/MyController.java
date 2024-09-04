package com.microsoft.example.azure_app_config_flux_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.cloud.appconfiguration.config.AppConfigurationRefresh;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping
public class MyController {
    
    @Autowired
    private MyProperties properties;

    @Autowired
    private AppConfigurationRefresh refresh;
    
    @GetMapping("/")
    public Mono<String> getMessage() throws Exception {
        refresh.refreshConfigurations().subscribeOn(Schedulers.boundedElastic()).subscribe();
        return Mono.just(properties.getMessage());
    }


}
