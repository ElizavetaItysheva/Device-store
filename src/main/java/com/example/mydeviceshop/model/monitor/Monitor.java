package com.example.mydeviceshop.model.monitor;

import com.example.mydeviceshop.model.Device;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "monitors")
@Getter
@Setter
public class Monitor extends Device {
    @Column(name = "diagonal")
    private Double diagonal;
}
