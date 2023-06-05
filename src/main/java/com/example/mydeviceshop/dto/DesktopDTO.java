package com.example.mydeviceshop.dto;

import com.example.mydeviceshop.model.Type;
import com.example.mydeviceshop.model.desktop.Desktop;
import com.example.mydeviceshop.model.desktop.FormFactor;
import lombok.Data;

@Data
public class DesktopDTO {
    private FormFactor formFactor;
    private String seriesNumber;
    private String manufacturer;
    private Long price;
    private Long amount;

    public static Desktop toModel( DesktopDTO newDesktop ) {
        Desktop desktop = new Desktop();
        desktop.setFormFactor(newDesktop.getFormFactor());
        desktop.setType(Type.DESKTOP);
        desktop.setSeriesNumber(newDesktop.getSeriesNumber());
        desktop.setManufacturer(newDesktop.getManufacturer());
        desktop.setPrice(newDesktop.getPrice());
        desktop.setAmount(newDesktop.getAmount());
        return desktop;
    }

    public static DesktopDTO fromModel( Desktop desktop ) {
        DesktopDTO dto = new DesktopDTO();
        dto.setFormFactor(desktop.getFormFactor());
        dto.setSeriesNumber(desktop.getSeriesNumber());
        dto.setManufacturer(desktop.getManufacturer());
        dto.setPrice(desktop.getPrice());
        dto.setAmount(desktop.getAmount());
        return dto;
    }
}
