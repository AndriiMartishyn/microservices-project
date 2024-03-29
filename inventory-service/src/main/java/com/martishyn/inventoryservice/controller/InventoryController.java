package com.martishyn.inventoryservice.controller;

import com.martishyn.inventoryservice.dto.InventoryResponse;
import com.martishyn.inventoryservice.service.InventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        log.info("Received inventory check request for skuCodes: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }
}
