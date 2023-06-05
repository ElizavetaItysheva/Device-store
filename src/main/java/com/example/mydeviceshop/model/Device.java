package com.example.mydeviceshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class Device {
    @Enumerated(value = EnumType.STRING)
    @Column(name = "class")
    private Type type;
    @Id
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long amount;
}
