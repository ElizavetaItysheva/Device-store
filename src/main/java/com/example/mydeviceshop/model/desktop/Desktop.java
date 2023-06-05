package com.example.mydeviceshop.model.desktop;

import com.example.mydeviceshop.model.Device;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "desktops")
@Getter
@Setter
public class Desktop extends Device {
    @Enumerated(value = EnumType.STRING)
    @Column(name = "form_factor")
    private FormFactor formFactor;
}
