package com.martishyn.inventoryservice.repository;

import com.martishyn.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select inv from Inventory inv where inv.skuCode=?1")
    Optional<Inventory> isProductInStock(String skuCode);

}
