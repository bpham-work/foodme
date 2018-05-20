package com.brofindr.application.repository;

import com.brofindr.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByStoreId(String storeId);
}
