package com.springboot.advanced_jpa.service.impl;

import com.springboot.advanced_jpa.data.dao.ProductDao;
import com.springboot.advanced_jpa.data.dto.ProductDto;
import com.springboot.advanced_jpa.data.dto.ProductResponseDto;
import com.springboot.advanced_jpa.data.dto.ProductResponseDto.ProductResponseDtoBuilder;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductDao productDao;

  @Autowired
  public ProductServiceImpl(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public ProductResponseDto getProduct(Long number) {
    Product product = productDao.selectProduct(number);

    ProductResponseDto productResponseDto = new ProductResponseDtoBuilder()
        .number(product.getNumber())
        .name(product.getName())
        .price(product.getPrice())
        .stock(product.getStock())
        .build();

    return productResponseDto;
  }

  @Override
  public ProductResponseDto saveProduct(ProductDto productDto) {
    Product product = new Product();
    product.setName(productDto.getName());
    product.setPrice(productDto.getPrice());
    product.setStock(productDto.getStock());
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(LocalDateTime.now());

    Product savedProduct = productDao.insertProduct(product);

    ProductResponseDto productResponseDto = new ProductResponseDtoBuilder()
        .number(savedProduct.getNumber())
        .name(savedProduct.getName())
        .price(savedProduct.getPrice())
        .stock(savedProduct.getStock())
        .build();

    return productResponseDto;
  }

  @Override
  public ProductResponseDto changeProductName(Long number, String name) throws Exception {
    Product changedProduct = productDao.updateProductName(number, name);

    ProductResponseDto productResponseDto = new ProductResponseDtoBuilder()
        .number(changedProduct.getNumber())
        .name(changedProduct.getName())
        .price(changedProduct.getPrice())
        .stock(changedProduct.getStock())
        .build();

    return productResponseDto;
  }

  @Override
  public void deleteProduct(Long number) throws Exception {
    productDao.deleteProduct(number);
  }
}
