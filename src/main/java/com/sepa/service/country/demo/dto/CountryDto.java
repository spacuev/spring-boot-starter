package com.sepa.service.country.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CountryDto implements Serializable {

    private NameDto name;

    @JsonProperty("cioc")
    private String code;

    private List<String> capital;

    private int population;

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
