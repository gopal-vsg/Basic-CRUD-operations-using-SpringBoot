package com.example.demo.ApiService;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productrepo;

    public List<Product> findAll(){
        return productrepo.findAll();
    }
    public Product findById(int id) {
        return productrepo.findById(id).orElse(null);
    }
    public Product save(Product product){
        return productrepo.save(product);
    }
    public void Delete(int id){
        productrepo.deleteById(id);
    }

}
