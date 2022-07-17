package service;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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

    public Product findProdById(Long id){
        return productRepository.findOne(id);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product editProduct(Product product){
        return  productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
