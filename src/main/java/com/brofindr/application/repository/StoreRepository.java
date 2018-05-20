package com.brofindr.application.repository;

import com.brofindr.domain.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, String> {
    boolean existsByGoogleId(String googleId);
}
