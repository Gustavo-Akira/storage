package br.com.gustavoakira.industry.storage.exception;

import lombok.Data;

@Data
public class ProductNotFoundException extends RuntimeException {
     public ProductNotFoundException(Long id){
        super("Product not found with " + id);
     }
}
