package com.example.mydeviceshop.dto;

import com.example.mydeviceshop.model.Type;
import com.example.mydeviceshop.model.laptop.Inches;
import com.example.mydeviceshop.model.laptop.Laptop;
import lombok.Data;

@Data
public class LaptopDTO {
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long amount;
    private Inches inches;

    public static Laptop toModel( LaptopDTO dto ) {
        Laptop laptop = new Laptop();
        laptop.setType(Type.LAPTOP);
        laptop.setSeriesNumber(dto.getSeriesNumber());
        laptop.setManufacturer(dto.getManufacturer());
        laptop.setPrice(dto.getPrice());
        laptop.setAmount(dto.getAmount());
        laptop.setInches(dto.getInches());
        return laptop;
    }

    public static LaptopDTO fromModel( Laptop laptop ) {
        LaptopDTO dto = new LaptopDTO();
        dto.setSeriesNumber(laptop.getSeriesNumber());
        dto.setManufacturer(laptop.getManufacturer());
        dto.setPrice(laptop.getPrice());
        dto.setAmount(laptop.getAmount());
        dto.setInches(laptop.getInches());
        return dto;
    }
}
