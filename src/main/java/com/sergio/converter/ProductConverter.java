package com.sergio.converter;

import com.sergio.domain.Product;
import com.sergio.dto.ProductDto;
import com.sergio.exception.InvalidArgumentException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public ProductConverter(){}

    public Product fromDto(ProductDto dto) {
        if (dto == null) {
            throw new InvalidArgumentException("Can't be null");
        }
            Product product = new Product();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setPrice(dto.getPrice());
            return product;
    }

    public ProductDto toDto(Product product) {
        if (product == null) {
            throw new InvalidArgumentException("Can't be null");
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public List<Product> fromDtoList(List<ProductDto> dto){
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto: dto) {
            products.add(fromDto(productDto));
        }
        return products;
    }

    public List<ProductDto> toDtoList(List<Product> products){
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product: products) {
            productsDto.add(toDto(product));
        }
        return productsDto;
    }
}
