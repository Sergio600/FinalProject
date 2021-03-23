package com.sergio.service;

import com.sergio.domain.Product;
import com.sergio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.getAllProducts();
        return products;
    }
}
