package br.com.gustavoakira.industry.storage.service.impl;

import br.com.gustavoakira.industry.storage.entity.Product;
import br.com.gustavoakira.industry.storage.exception.ProductNotFoundException;
import br.com.gustavoakira.industry.storage.repository.ProductRepository;
import br.com.gustavoakira.industry.storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public void saveNewProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void updateProduct(Long id,Product product) {
        Product old = getProduct(id);
        product.setId(old.getId());
        repository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow(()->new ProductNotFoundException(id));
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public void removeProduct(Long id) {
        Product old = getProduct(id);
        repository.delete(old);
    }
}
