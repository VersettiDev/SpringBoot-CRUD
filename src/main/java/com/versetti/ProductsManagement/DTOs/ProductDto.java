package com.versetti.ProductsManagement.DTOs;

public record ProductDto(String name, String description, Integer stock, Long price) {
    public ProductDto {
        description = description != null ? description : "Sem descrição";
        stock = stock != null ? stock : 0;
    }

    public ProductDto(String name, Long price) {
        this(name, null, null, price);
    }
}
