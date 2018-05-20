package com.brofindr.application.controller;

import com.brofindr.application.service.ItemService;
import com.brofindr.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = Routes.GET_ITEMS, method = RequestMethod.GET)
    public List<Item> getItems(@PathVariable String storeId) {
        return itemService.getItemsByStoreId(storeId);
    }

    @RequestMapping(value = Routes.UNAVAILABLE_ITEM, method = RequestMethod.GET)
    public List<Item> unavailableItem(@PathVariable String itemId) {
        return itemService.setUnavailable(Long.parseLong(itemId));
    }

    @RequestMapping(value = Routes.AVAILABLE_ITEM, method = RequestMethod.GET)
    public List<Item> availableItem(@PathVariable String itemId) {
        return itemService.setAvailable(Long.parseLong(itemId));
    }
}
