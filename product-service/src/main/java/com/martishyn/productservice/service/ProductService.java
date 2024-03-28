package com.martishyn.productservice.service;

import com.martishyn.productservice.dto.ProductRequest;
import com.martishyn.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
