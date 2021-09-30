package com.springboot_crud_example.controller;

import com.springboot_crud_example.entity.Product;
import com.springboot_crud_example.service.ProductService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@EnableSwagger2
public class ProductController {

    @Autowired
    private ProductService repository;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return repository.saveProduct(product);
    }

    @PostMapping("/allProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return repository.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return repository.getProducts();
    }

    @GetMapping("/productid/{id}")
    public Product findProductById(@PathVariable int id){
        return repository.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return repository.getProductByName(name);
    }


    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return repository.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return repository.deleteProductById(id);
    }


}