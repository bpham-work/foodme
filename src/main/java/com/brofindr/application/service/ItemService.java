package com.brofindr.application.service;

import com.brofindr.application.repository.ItemReportRepository;
import com.brofindr.application.repository.ItemRepository;
import com.brofindr.domain.Item;
import com.brofindr.domain.ItemReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemReportRepository itemReportRepository;

    String[] items = {
            "Milk",
            "Cereal",
            "Bread",
            "Pizza",
            "Chicken"
    };

    public List<Item> getItemsByStoreId(String storeId) {
        return getLatest(storeId);
    }

    public List<Item> setUnavailable(Long itemId) {
        ItemReport report = ItemReport.createUnavailable(itemId);
        itemReportRepository.save(report);
        Item item = itemRepository.findById(itemId).get();
        return getLatest(item.getStoreId());
    }

    public List<Item> setAvailable(Long itemId) {
        ItemReport report = ItemReport.createAvailable(itemId);
        itemReportRepository.save(report);
        Item item = itemRepository.findById(itemId).get();
        return getLatest(item.getStoreId());
    }

    public void createDefaultItems(String storeId) {
        for (String item : items) {
            itemRepository.save(new Item(storeId, item));
        }
    }

    private List<Item> getLatest(String storeId) {
        List<Item> items = itemRepository.findByStoreId(storeId);
        for (Item item : items) {
            List<ItemReport> report = itemReportRepository.findByItemId(item.itemId);
            Boolean avail = true;
            if (report.size() > 0) {
                avail = report.get(report.size()-1).available;
            }
            item.setAvailability(avail);
        }
        return items;
    }
}
