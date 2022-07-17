package service;

import models.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryProductRepository;

import java.util.List;

public class ProductCategoryService {
    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public ProductCategoryService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }


    public List<CategoryProduct> findAllCategory( ){
        return categoryProductRepository.findAll();
    }


    public CategoryProduct findProdCatById(Long id) throws Exception{
        return categoryProductRepository.findProductCategoryById(id)
                .orElseThrow(() -> new Exception("product Category by id " + id + " was not found"));
    }
    public CategoryProduct addCat(CategoryProduct categoryProduct){
        return categoryProductRepository.save(categoryProduct);
    }

    public CategoryProduct editCat(CategoryProduct categoryProduct){
        return  categoryProductRepository.save(categoryProduct);
    }

    public void deleteCat(Long id){
        categoryProductRepository.deleteById(id);
    }
}
