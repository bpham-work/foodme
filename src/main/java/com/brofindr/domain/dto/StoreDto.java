package com.brofindr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StoreDto {
    public String id;
    public String name;
    public Integer rating;
    public Geometry geometry;
}
