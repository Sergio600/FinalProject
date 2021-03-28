package com.sergio.service;

import com.sergio.converter.ProductConverter;
import com.sergio.domain.Product;
import com.sergio.dto.ProductDto;
import com.sergio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.getAllProducts();
        return productConverter.toDtoList(products);
    }

    public ProductDto getById(int id){
        Product product = productRepository.getProductById(id);
        return productConverter.toDto(product);
    }
}
