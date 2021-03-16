package br.com.gustavoakira.industry.storage.service;

import br.com.gustavoakira.industry.storage.entity.Product;

import java.util.List;

public interface ProductService {
    void saveNewProduct(Product product);
    void updateProduct(Long id,Product product);
    Product getProduct(Long id);
    List<Product> getProducts();
    void removeProduct(Long id);
}
