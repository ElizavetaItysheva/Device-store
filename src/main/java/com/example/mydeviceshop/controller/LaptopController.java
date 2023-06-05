package com.example.mydeviceshop.controller;

import com.example.mydeviceshop.dto.LaptopDTO;
import com.example.mydeviceshop.service.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService service;

    public LaptopController( LaptopService service ) {
        this.service = service;
    }

    @Operation(
            summary = "Добавление ноутбука", tags = "Ноутбуки",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LaptopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PostMapping
    public ResponseEntity<LaptopDTO> addLaptop( @RequestBody LaptopDTO item ) {
        if (item == null) {
            throw new NullPointerException("Заполните поля!");
        }
        LaptopDTO result = service.addLaptop(item);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Обновление информации о ноутбуке по серийному номеру", tags = "Ноутбуки",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LaptopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PutMapping
    public ResponseEntity<LaptopDTO> updateLaptop( @RequestParam String seriesNumber, @RequestBody LaptopDTO dto ) {
        LaptopDTO result = service.updateLaptop(seriesNumber, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Получение информации о всех ноутбуках", tags = "Ноутбуки",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LaptopDTO.class))})
            })
    @GetMapping
    public ResponseEntity<List<LaptopDTO>> getAllLaptops() {
        List<LaptopDTO> results = service.getAll();
        return ResponseEntity.ok(results);
    }

    @Operation(
            summary = "Получение информации о ноутбуке по серийному номеру", tags = "Ноутбуки",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LaptopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    @GetMapping("/{seriesNumber}")
    public ResponseEntity<LaptopDTO> getBySeriesNumber( @PathVariable String seriesNumber ) {
        LaptopDTO result = service.getBySeriesNumber(seriesNumber);
        return ResponseEntity.ok(result);
    }
}
