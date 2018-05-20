package com.brofindr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long itemId;
    private String storeId;
    private String name;
    private Boolean availability;
    private int quantity;

    public String getStoreId() { return storeId; }

    public Item(String storeId, String name) {
        this.storeId = storeId;
        this.name = name;
    }

    public void setAvailability(Boolean avail) {
        availability = avail;
    }
}
