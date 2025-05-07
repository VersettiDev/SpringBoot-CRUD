package com.versetti.ProductsManagement.controllers;

import com.versetti.ProductsManagement.DTOs.ProductDto;
import com.versetti.ProductsManagement.entity.Product;
import com.versetti.ProductsManagement.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts () {
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @PostMapping
    public ResponseEntity saveNewProduct (@RequestBody ProductDto dto) {
        var newProduct = new Product();
        BeanUtils.copyProperties(dto, newProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById (@PathVariable(name = "id") Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID ( " + id + " ) not found");
        }

        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product with ID ( " + id + " ) deleted");
    }
}
