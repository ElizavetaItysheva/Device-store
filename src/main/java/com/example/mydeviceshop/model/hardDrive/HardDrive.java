package com.example.mydeviceshop.model.hardDrive;

import com.example.mydeviceshop.model.Device;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "hard_drive")
@Getter
@Setter
public class HardDrive extends Device {
    @Column(name = "capacity")
    private Long capacity;
}
