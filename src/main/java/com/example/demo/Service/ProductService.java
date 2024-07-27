package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> findById(int id) {
        return productrepo.findById(id);
    }

    public Product save(Product product){
        return productrepo.save(product);
    }
    public void Delete(int id){
        productrepo.deleteById(id);
    }

}
