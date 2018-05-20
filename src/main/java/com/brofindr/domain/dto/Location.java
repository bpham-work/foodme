package com.brofindr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Location {
    private Double lat;
    private Double lng;

    public Double getLat() { return lat; }
    public Double getLng() { return lng; }
}
