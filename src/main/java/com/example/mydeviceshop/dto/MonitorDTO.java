package com.example.mydeviceshop.dto;

import com.example.mydeviceshop.model.Type;
import com.example.mydeviceshop.model.monitor.Monitor;
import lombok.Data;

@Data
public class MonitorDTO {
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long amount;
    private Double diagonal;

    public static Monitor toModel( MonitorDTO dto ) {
        Monitor monitor = new Monitor();
        monitor.setType(Type.MONITOR);
        monitor.setSeriesNumber(dto.getSeriesNumber());
        monitor.setManufacturer(dto.getManufacturer());
        monitor.setPrice(dto.getPrice());
        monitor.setAmount(dto.getAmount());
        monitor.setDiagonal(dto.getDiagonal());
        return monitor;
    }

    public static MonitorDTO fromModel( Monitor monitor ) {
        MonitorDTO dto = new MonitorDTO();
        dto.setSeriesNumber(monitor.getSeriesNumber());
        dto.setManufacturer(monitor.getManufacturer());
        dto.setPrice(monitor.getPrice());
        dto.setAmount(monitor.getAmount());
        dto.setDiagonal(monitor.getDiagonal());
        return dto;
    }
}
