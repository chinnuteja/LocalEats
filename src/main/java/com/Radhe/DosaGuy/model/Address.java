package com.Radhe.DosaGuy.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
