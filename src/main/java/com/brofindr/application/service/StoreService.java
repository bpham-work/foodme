package com.brofindr.application.service;

import com.brofindr.application.repository.StoreRepository;
import com.brofindr.domain.Store;
import com.brofindr.domain.dto.Geocode;
import com.brofindr.domain.dto.GeocodeResponse;
import com.brofindr.domain.dto.PlacesResponse;
import com.brofindr.domain.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StoreService {
    private RestTemplate restTemplate;
    private StoreRepository storeRepository;
    private ItemService itemService;

    private String STORES_URI = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=1500&keyword=grocery&key=AIzaSyAQTaJr3r2jm0PadmzUgFJZwqXz3GY7MS4";
    private String GEOCODE_URI = "http://maps.googleapis.com/maps/api/geocode/json?address=%s";

    @Autowired
    public StoreService(RestTemplate restTemplate, ItemService itemService, StoreRepository storeRepository) {
        this.restTemplate = restTemplate;
        this.storeRepository = storeRepository;
        this.itemService = itemService;
    }

    public List<StoreDto> getStores(String zip) {
        String geocodeUri = String.format(GEOCODE_URI, zip);
        ResponseEntity<GeocodeResponse> r = restTemplate.getForEntity(geocodeUri, GeocodeResponse.class);
        System.out.println(geocodeUri);
        Geocode geocode = r.getBody().getResults();
        String uri = String.format(STORES_URI, geocode.getLat(), geocode.getLon());
        System.out.println(uri);
        List<StoreDto> results = restTemplate.getForEntity(uri, PlacesResponse.class).getBody().getResults();

        for (StoreDto dto : results) {
            if (!storeRepository.existsByGoogleId(dto.id)) {
                storeRepository.save(new Store(dto));
                createDefaultItems(dto.id);
            }
        }

        return results;
    }

    private void createDefaultItems(String storeId) {
        itemService.createDefaultItems(storeId);
    }
}
