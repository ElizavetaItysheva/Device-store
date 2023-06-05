package com.example.mydeviceshop.controller;

import com.example.mydeviceshop.dto.MonitorDTO;
import com.example.mydeviceshop.service.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
public class MonitorController {
    private final MonitorService service;

    public MonitorController( MonitorService service ) {
        this.service = service;
    }

    @Operation(
            summary = "Добавление монитора", tags = "Мониторы",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MonitorDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PostMapping
    public ResponseEntity<MonitorDTO> addMonitor( @RequestBody MonitorDTO item ) {
        if (item == null) {
            throw new NullPointerException("Заполните поля!");
        }
        MonitorDTO result = service.addMonitor(item);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Обновление информации о мониторе по серийному номеру", tags = "Мониторы",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MonitorDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PutMapping
    public ResponseEntity<MonitorDTO> updateMonitor( @RequestParam String seriesNumber, @RequestBody MonitorDTO dto ) {
        MonitorDTO result = service.updateMonitor(seriesNumber, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Получение информации о всех мониторах", tags = "Мониторы",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MonitorDTO.class))})
            })
    @GetMapping
    public ResponseEntity<List<MonitorDTO>> getAllMonitors() {
        List<MonitorDTO> results = service.getAll();
        return ResponseEntity.ok(results);
    }

    @Operation(
            summary = "Получение информации о мониторе по серийному номеру", tags = "Мониторы",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MonitorDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    @GetMapping("/{seriesNumber}")
    public ResponseEntity<MonitorDTO> getBySeriesNumber( @PathVariable String seriesNumber ) {
        MonitorDTO result = service.getBySeriesNumber(seriesNumber);
        return ResponseEntity.ok(result);
    }
}
