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
public class PlacesResponse {
    private List<StoreDto> results;
    private String status;

    public List<StoreDto> getResults() { return results; }
}
