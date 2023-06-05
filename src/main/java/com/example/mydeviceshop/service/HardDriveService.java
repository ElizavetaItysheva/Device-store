package com.example.mydeviceshop.service;

import com.example.mydeviceshop.dto.HardDriveDTO;
import com.example.mydeviceshop.exception.DeviceNotFoundException;
import com.example.mydeviceshop.model.hardDrive.HardDrive;
import com.example.mydeviceshop.repository.HardDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardDriveService {
    private final HardDriveRepository repository;

    public HardDriveService( HardDriveRepository repository ) {
        this.repository = repository;
    }

    public HardDriveDTO addHardDrive( HardDriveDTO item ) {
        HardDrive thisHardDrive = HardDriveDTO.toModel(item);
        repository.save(thisHardDrive);
        return item;
    }

    public HardDriveDTO updateHardDrive( String seriesNumber, HardDriveDTO dto ) {
        HardDrive target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        target.setAmount(dto.getAmount());
        target.setManufacturer(dto.getManufacturer());
        target.setPrice(dto.getPrice());
        target.setSeriesNumber(dto.getSeriesNumber());
        target.setCapacity(dto.getCapacity());
        repository.save(target);
        return HardDriveDTO.fromModel(target);
    }

    public List<HardDriveDTO> getAll() {
        List<HardDrive> founded = repository.findAll();
        return founded.stream()
                .map(HardDriveDTO::fromModel)
                .collect(Collectors.toList());
    }

    public HardDriveDTO getBySeriesNumber( String seriesNumber ) {
        HardDrive target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        return HardDriveDTO.fromModel(target);
    }
}
