package br.com.gustavoakira.industry.storage.resource.impl;

import br.com.gustavoakira.industry.storage.dto.AddDTO;
import br.com.gustavoakira.industry.storage.entity.Product;
import br.com.gustavoakira.industry.storage.messenger.ProductMessenger;
import br.com.gustavoakira.industry.storage.resource.ProductResource;
import br.com.gustavoakira.industry.storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductResourceImpl implements ProductResource {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMessenger messenger;

    @Override
    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @Override
    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @Override
    @PostMapping("product")
    public ResponseEntity<Void> saveProduct(@RequestBody Product product) {
        service.saveNewProduct(product);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("product/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        service.updateProduct(id, newProduct);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
        service.removeProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("product/{id}/quantity/add")
    public ResponseEntity<Void> addProduct(@PathVariable Long id, @RequestBody AddDTO quantity) {
        Product product = service.getProduct(id);
        messenger.send("ProductRequest",messenger.transformToData(product));
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("product/{id}/quantity/reduce")
    public ResponseEntity<Void> reduceProduct(Long id, Integer quantity) {
        return null;
    }
}
