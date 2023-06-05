package com.example.mydeviceshop.controller;

import com.example.mydeviceshop.dto.DesktopDTO;
import com.example.mydeviceshop.service.DesktopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desktops")
public class DesktopController {
    private final DesktopService desktopService;

    public DesktopController( DesktopService desktopService ) {
        this.desktopService = desktopService;
    }

    @Operation(
            summary = "Добавление настольного компьютера", tags = "Настольные компьютеры",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DesktopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PostMapping
    public ResponseEntity<DesktopDTO> addDesktop( @RequestBody DesktopDTO item ) {
        if (item == null) {
            throw new NullPointerException("Заполните поля!");
        }
        DesktopDTO desktop = desktopService.addDesktop(item);
        return ResponseEntity.ok(desktop);
    }

    @Operation(
            summary = "Обновление информации о настольном компьютере по серийному номеру", tags = "Настольные компьютеры",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DesktopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    @PutMapping
    public ResponseEntity<DesktopDTO> updateDesktop( @RequestParam String seriesNumber, @RequestBody DesktopDTO dto ) {
        DesktopDTO result = desktopService.updateDesktop(seriesNumber, dto);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Получение информации о всех настольных компьютерах", tags = "Настольные компьютеры",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DesktopDTO.class))})
            })
    @GetMapping
    public ResponseEntity<List<DesktopDTO>> getAllDesktops() {
        List<DesktopDTO> results = desktopService.getAll();
        return ResponseEntity.ok(results);
    }

    @Operation(
            summary = "Получение информации о настольном компьютере по серийному номеру", tags = "Настольные компьютеры",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DesktopDTO.class))}),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    @GetMapping("/{seriesNumber}")
    public ResponseEntity<DesktopDTO> getBySeriesNumber( @PathVariable String seriesNumber ) {
        DesktopDTO result = desktopService.getBySeriesNumber(seriesNumber);
        return ResponseEntity.ok(result);
    }
}
