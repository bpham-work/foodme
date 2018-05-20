package com.brofindr.domain;

import com.brofindr.domain.dto.StoreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String googleId;
    private String name;
    private String lat;
    private String lon;

    public Store(String googleId, String name) {
        this.googleId = googleId;
        this.name = name;
    }

    public Store(StoreDto dto) {
        this.googleId = dto.id;
        this.name = dto.name;
    }
}
