package br.com.gustavoakira.industry.storage.resource;

import br.com.gustavoakira.industry.storage.dto.AddDTO;
import br.com.gustavoakira.industry.storage.entity.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ProductResource {
    @ApiOperation(value = "Return the searched product")
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Return the product with the id"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Occurred a exception")
    })
    ResponseEntity<Product> getProduct(Long id);

    @ApiOperation(value = "Return a list of all products")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Return the list of products"),
            @ApiResponse(code = 500, message = "Occurred a exception")
    })
    ResponseEntity<List<Product>> getProducts();
    @ApiOperation(value = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 204,message = "Product created successfully"),
            @ApiResponse(code= 500, message = "Occurred a exception")
    })
    ResponseEntity<Void> saveProduct(Product product);
    @ApiOperation(value = "Update a existent product")
    @ApiResponses(value = {
            @ApiResponse(code = 204,message = "Product updated successfully"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code= 500, message = "Occurred a exception")
    })
    ResponseEntity<Void> updateProduct(Long id, Product newProduct);
    @ApiOperation(value = "Remove a product")
    @ApiResponses(value = {
            @ApiResponse(code = 204,message = "Product removed successfully"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code= 500, message = "Occurred a exception")
    })
    ResponseEntity<Void> removeProduct(Long id);
    @ApiOperation(value = "Request more of a certain product")
    @ApiResponses(value={
            @ApiResponse(code = 204,message = "Product requested with success"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code= 500, message = "Occurred a exception")
    })
    ResponseEntity<Void> addProduct(Long id, AddDTO quantity);
    @ApiOperation(value = "Reduce the quantity of a certain product")
    @ApiResponses(value={
            @ApiResponse(code = 204,message = "Reduced with success"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code= 500, message = "Occurred a exception")
    })
    ResponseEntity<Void> reduceProduct(Long id, Integer quantity);
}
