package com.springboot_crud_example.service;

import com.springboot_crud_example.entity.Product;
import com.springboot_crud_example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     *
     * @param product
     * @return
     *
     * Two below APIs are Post methods
     */

    // Below method take 'product' as argument and save it
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    // Now if you want 'ALL PRODUCT'
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    // Let's create 'Get' methods APIs
    // to fetch products object from DB
    public  List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        // findbyid return optional and the rest in case it is null
        return repository.findById(id).orElse(null);
    }
    // Just as the above code we can customize for other fields

    public Product getProductByName(String name){
        // findbyid return optional and the rest in case it is null
        return repository.findByName(name);
    }

    // Now let's create methods for 'Put' and 'Delete' for CRUD operations
    public String deleteProductById(int id){
        repository.deleteById(id);
        return "Product removed: " + id;
    }

    // Because there's 'NO UPDATE' method in Spring Data JPA, we use save method
    public Product updateProduct(Product product){
        Product existingProduct = repository.getById(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }
}