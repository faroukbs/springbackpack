package service;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAllProduct( ){
        return productRepository.findAll();
    }

    public Product findProdById(Long id) throws Exception{
        return productRepository.findProductById(id)
                .orElseThrow(() -> new Exception("product by id " + id + " was not found"));
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product editProduct(Product product){
        return  productRepository.save(product);
    }

    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }
}
