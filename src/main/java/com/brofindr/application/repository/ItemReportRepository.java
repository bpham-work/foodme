package com.brofindr.application.repository;

import com.brofindr.domain.Item;
import com.brofindr.domain.ItemReport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemReportRepository extends CrudRepository<ItemReport, Long> {
    List<ItemReport> findByItemId(Long itemId);
}
