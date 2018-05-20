package com.brofindr.application.controller;

import com.brofindr.application.service.StoreService;
import com.brofindr.domain.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = Routes.GET_STORES, method = RequestMethod.GET)
    public List<StoreDto> getStores(@PathVariable String zip) {
        return storeService.getStores(zip);
    }
}
