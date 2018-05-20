package com.brofindr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="itemreport")
public class ItemReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long itemId;
    @CreatedDate
    private DateTime datetime;
    public Boolean available;

    public ItemReport(Boolean available, Long itemId) {
        this.available = available;
        this.itemId = itemId;
    }

    public static ItemReport createUnavailable(Long itemId) {
        return new ItemReport(false, itemId);
    }

    public static ItemReport createAvailable(Long itemId) {
        return new ItemReport(true, itemId);
    }
}
