package com.example.mydeviceshop.service;

import com.example.mydeviceshop.dto.DesktopDTO;
import com.example.mydeviceshop.exception.DeviceNotFoundException;
import com.example.mydeviceshop.model.desktop.Desktop;
import com.example.mydeviceshop.repository.DesktopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesktopService {
    private final DesktopRepository repository;

    public DesktopService( DesktopRepository repository ) {
        this.repository = repository;
    }

    public DesktopDTO addDesktop( DesktopDTO item ) {
        Desktop thisDesktop = DesktopDTO.toModel(item);
        repository.save(thisDesktop);
        return item;
    }

    public DesktopDTO updateDesktop( String seriesNumber, DesktopDTO item ) {
        Desktop target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        target.setAmount(item.getAmount());
        target.setManufacturer(item.getManufacturer());
        target.setFormFactor(item.getFormFactor());
        target.setPrice(item.getPrice());
        target.setSeriesNumber(item.getSeriesNumber());
        repository.save(target);
        return DesktopDTO.fromModel(target);
    }

    public List<DesktopDTO> getAll() {
        List<Desktop> founded = repository.findAll();
        return founded.stream()
                .map(DesktopDTO::fromModel)
                .collect(Collectors.toList());
    }

    public DesktopDTO getBySeriesNumber( String seriesNumber ) {
        Desktop target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        return DesktopDTO.fromModel(target);
    }
}
