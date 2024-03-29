package com.martishyn.inventoryservice.service;

import com.martishyn.inventoryservice.dto.InventoryResponse;
import com.martishyn.inventoryservice.model.Inventory;
import com.martishyn.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes){
       return inventoryRepository.isProductInStock(skuCodes)
               .stream()
               .map(InventoryService::createInventoryResponse).toList();
    }

    private static InventoryResponse createInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
