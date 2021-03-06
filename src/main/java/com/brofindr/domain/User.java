package com.brofindr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String email;
    private String displayName;
    private String registrationId;

    public User(String email, String displayName, String registrationId) {
        this.email = email;
        this.displayName = displayName;
        this.registrationId = registrationId;
    }
}
