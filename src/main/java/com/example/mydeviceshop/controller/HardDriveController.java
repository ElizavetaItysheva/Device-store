package com.example.mydeviceshop.controller;

import com.example.mydeviceshop.dto.HardDriveDTO;
import com.example.mydeviceshop.service.HardDriveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardDrives")
public class HardDriveController {
    private final HardDriveService service;

    public HardDriveController( HardDriveService service ) {
        this.service = service;
    }

    @Operation(
            summary = "Добавление жесткого диска", tags = "Жесткие диски",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = HardDriveDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PostMapping
    public ResponseEntity<HardDriveDTO> addHardDrive( @RequestBody HardDriveDTO item ) {
        if (item == null) {
            throw new NullPointerException("Заполните поля!");
        }
        HardDriveDTO result = service.addHardDrive(item);
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Обновление информации о жестком диске по серийному номеру", tags = "Жесткие диски",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = HardDriveDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PutMapping
    public ResponseEntity<HardDriveDTO> updateHardDrive( @RequestParam String seriesNumber, @RequestBody HardDriveDTO dto ) {
        HardDriveDTO result = service.updateHardDrive(seriesNumber, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Получение информации о всех жестких дисках", tags = "Жесткие диски",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = HardDriveDTO.class))})
            })
    @GetMapping
    public ResponseEntity<List<HardDriveDTO>> getAllHardDrives() {
        List<HardDriveDTO> results = service.getAll();
        return ResponseEntity.ok(results);
    }

    @Operation(
            summary = "Получение информации о жестком диске по серийному номеру", tags = "Жесткие диски",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = HardDriveDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    @GetMapping("/{seriesNumber}")
    public ResponseEntity<HardDriveDTO> getBySeriesNumber( @PathVariable String seriesNumber ) {
        HardDriveDTO result = service.getBySeriesNumber(seriesNumber);
        return ResponseEntity.ok(result);
    }
}
