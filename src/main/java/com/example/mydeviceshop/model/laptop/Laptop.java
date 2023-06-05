package com.example.mydeviceshop.model.laptop;

import com.example.mydeviceshop.model.Device;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "laptops")
@Getter
@Setter
public class Laptop extends Device {
    @Enumerated(value = EnumType.STRING)
    @Column(name = "inches")
    private Inches inches;
}
