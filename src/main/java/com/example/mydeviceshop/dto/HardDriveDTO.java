package com.example.mydeviceshop.dto;

import com.example.mydeviceshop.model.Type;
import com.example.mydeviceshop.model.hardDrive.HardDrive;
import lombok.Data;

@Data
public class HardDriveDTO {
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long amount;
    private Long capacity;

    public static HardDrive toModel( HardDriveDTO dto ) {
        HardDrive hardDrive = new HardDrive();
        hardDrive.setType(Type.HARD_DRIVE);
        hardDrive.setSeriesNumber(dto.getSeriesNumber());
        hardDrive.setManufacturer(dto.getManufacturer());
        hardDrive.setPrice(dto.getPrice());
        hardDrive.setAmount(dto.getAmount());
        hardDrive.setCapacity(dto.getCapacity());
        return hardDrive;
    }

    public static HardDriveDTO fromModel( HardDrive hardDrive ) {
        HardDriveDTO dto = new HardDriveDTO();
        dto.setSeriesNumber(hardDrive.getSeriesNumber());
        dto.setManufacturer(hardDrive.getManufacturer());
        dto.setPrice(hardDrive.getPrice());
        dto.setAmount(hardDrive.getAmount());
        dto.setCapacity(hardDrive.getCapacity());
        return dto;
    }
}
