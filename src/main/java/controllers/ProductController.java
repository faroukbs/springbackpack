package controllers;

import models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAllProduct();
    }

    @PostMapping("/addproduct")
    public Product newProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.editProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable("id") Long id) {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findproduct/{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable("id") Long id) throws Exception {
        Product product = productService.findProdById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
