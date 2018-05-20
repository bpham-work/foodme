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
    private String address;
    private Double lat;
    private Double lng;
    @Transient
    private String photoUrl;

    @Transient
    private static String PHOTO_URI =
            "https://maps.googleapis.com/maps/api/place/photo?maxwidth=800&photoreference=%s&key=AIzaSyAQTaJr3r2jm0PadmzUgFJZwqXz3GY7MS4";

    public Store(String googleId, String name) {
        this.googleId = googleId;
        this.name = name;
    }

    public Store(StoreDto dto) {
        this.googleId = dto.id;
        this.name = dto.name;
        this.address = dto.vicinity;
        this.lat = dto.geometry.getLocation().getLat();
        this.lng = dto.geometry.getLocation().getLng();
        if (dto.photos.size() > 0)
            this.photoUrl = String.format(PHOTO_URI, dto.photos.get(0).photo_reference);
    }
}
