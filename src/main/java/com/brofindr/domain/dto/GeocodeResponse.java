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
public class GeocodeResponse {
    private List<Geocode> results;
    private String status;

    public Geocode getResults() { return results.get(0); }
}
