package com.sepa.service.country.demo.rest;

import com.sepa.service.country.demo.dto.CountryDto;
import com.sepa.service.country.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@PropertySource(value = "classpath:application.properties")
public class CountryController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${host.url:}")
    private String hostUrl;

    @GetMapping("/{code}")
    public Country getCountryInfo(@PathVariable String code) {

        try {

            System.out.println("uri = " + hostUrl);

            URI requestUri = new URI(hostUrl + "/v3.1/name/" + code);

            CountryDto[] response = restTemplate.getForObject(requestUri, CountryDto[].class);

            if (response.length == 1) {
                return toEntity(response[0]);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error ", e);
        }
    }

    private Country toEntity(CountryDto dto) {
        Country country = new Country();

        country.setCode(dto.getCode());
        if (dto.getName() != null) {
            country.setShortName(dto.getName().getCommon());
            country.setOfficialName(dto.getName().getOfficial());
        }
        if (dto.getCapital().size() > 0) {
            country.setCapital(dto.getCapital().get(0));
        }
        country.setPopulation(dto.getPopulation());
        return country;
    }

}
