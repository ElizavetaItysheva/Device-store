package com.example.mydeviceshop.service;

import com.example.mydeviceshop.dto.LaptopDTO;
import com.example.mydeviceshop.exception.DeviceNotFoundException;
import com.example.mydeviceshop.model.laptop.Laptop;
import com.example.mydeviceshop.repository.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopService {
    private final LaptopRepository repository;

    public LaptopService( LaptopRepository repository ) {
        this.repository = repository;
    }

    public LaptopDTO addLaptop( LaptopDTO item ) {
        Laptop thisLaptop = LaptopDTO.toModel(item);
        repository.save(thisLaptop);
        return item;
    }

    public LaptopDTO updateLaptop( String seriesNumber, LaptopDTO dto ) {
        Laptop target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        target.setAmount(dto.getAmount());
        target.setManufacturer(dto.getManufacturer());
        target.setPrice(dto.getPrice());
        target.setSeriesNumber(dto.getSeriesNumber());
        target.setInches(dto.getInches());
        repository.save(target);
        return LaptopDTO.fromModel(target);
    }

    public List<LaptopDTO> getAll() {
        List<Laptop> founded = repository.findAll();
        return founded.stream()
                .map(LaptopDTO::fromModel)
                .collect(Collectors.toList());
    }

    public LaptopDTO getBySeriesNumber( String seriesNumber ) {
        Laptop target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        return LaptopDTO.fromModel(target);
    }
}
