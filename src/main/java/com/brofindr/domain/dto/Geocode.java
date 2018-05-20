package com.brofindr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Geocode {
    private Geometry geometry;

    public Double getLat() {
        return geometry.getLocation().getLat();
    }

    public Double getLon() {
        return geometry.getLocation().getLng();
    }
}
