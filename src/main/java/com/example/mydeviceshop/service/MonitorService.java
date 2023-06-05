package com.example.mydeviceshop.service;

import com.example.mydeviceshop.dto.MonitorDTO;
import com.example.mydeviceshop.exception.DeviceNotFoundException;
import com.example.mydeviceshop.model.monitor.Monitor;
import com.example.mydeviceshop.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorService {
    private final MonitorRepository repository;

    public MonitorService( MonitorRepository repository ) {
        this.repository = repository;
    }

    public MonitorDTO addMonitor( MonitorDTO item ) {
        Monitor thisMonitor = MonitorDTO.toModel(item);
        repository.save(thisMonitor);
        return item;
    }

    public MonitorDTO updateMonitor( String seriesNumber, MonitorDTO dto ) {
        Monitor target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        target.setAmount(dto.getAmount());
        target.setManufacturer(dto.getManufacturer());
        target.setPrice(dto.getPrice());
        target.setSeriesNumber(dto.getSeriesNumber());
        target.setDiagonal(dto.getDiagonal());
        repository.save(target);
        return MonitorDTO.fromModel(target);
    }

    public List<MonitorDTO> getAll() {
        List<Monitor> founded = repository.findAll();
        return founded.stream()
                .map(MonitorDTO::fromModel)
                .collect(Collectors.toList());
    }

    public MonitorDTO getBySeriesNumber( String seriesNumber ) {
        Monitor target = repository.findBySeriesNumber(seriesNumber)
                .orElseThrow(DeviceNotFoundException::new);
        return MonitorDTO.fromModel(target);
    }

}
