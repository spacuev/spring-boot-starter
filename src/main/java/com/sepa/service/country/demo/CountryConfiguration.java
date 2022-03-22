package com.sepa.service.country.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConditionalOnWebApplication
public class CountryConfiguration {
}
