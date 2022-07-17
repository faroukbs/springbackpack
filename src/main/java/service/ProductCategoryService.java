package service;

import models.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductCategoryService {
    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public ProductCategoryService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }


    public List<CategoryProduct> findAllCategory( ){
        return categoryProductRepository.findAll();
    }

    public Optional<CategoryProduct> findProdById(Long id){
        return categoryProductRepository.findById(id);
    }

    public CategoryProduct addProduct(CategoryProduct categoryProduct){
        return categoryProductRepository.save(categoryProduct);
    }

    public CategoryProduct editProduct(CategoryProduct categoryProduct){
        return  categoryProductRepository.save(categoryProduct);
    }

    public void deleteProduct(Long id){
        categoryProductRepository.deleteById(id);
    }
}
