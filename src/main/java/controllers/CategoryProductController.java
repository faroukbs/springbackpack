package controllers;

import models.CategoryProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryProductController {
    private final ProductCategoryService productCategoryService;

    public CategoryProductController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryProduct>> getAllCategoryProduct() {
        List<CategoryProduct> categoryProducts = productCategoryService.findAllCategory();
        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CategoryProduct> getCategoryProductById(@PathVariable("id") Long id) throws Exception {
        CategoryProduct categoryProduct = productCategoryService.findProdCatById(id);
        return new ResponseEntity<>(categoryProduct, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryProduct> addCategory(@RequestBody CategoryProduct category) {
        CategoryProduct newCategory = productCategoryService.addCat(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryProduct> updateCategory(@RequestBody CategoryProduct category) {
        CategoryProduct updateCategory = productCategoryService.editCat(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        productCategoryService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
