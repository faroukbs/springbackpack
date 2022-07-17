package controllers;

import models.Product;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.findAllProduct();
    }

    @PostMapping("/addproduct")
    public Product newProduct (@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PostMapping("/edit/{id}")
    public Product updateProduct (@PathVariable Long id,@RequestBody Product product){
        Product prod = productService.findProdById(id);
        return prod;
    }

}
