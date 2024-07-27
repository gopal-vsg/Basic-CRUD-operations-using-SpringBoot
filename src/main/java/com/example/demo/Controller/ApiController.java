package com.example.demo.Controller;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ApiController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> showAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> showById(@PathVariable int id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product newSave = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        if (productService.findById(id).isPresent()) {
            product.setId(id); 
            Product updatedProduct = productService.save(product);
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean Dproduct = productService.findById(id).isPresent();
        if (!Dproduct) {
            return ResponseEntity.notFound().build();
        }
        productService.Delete(id);
        return ResponseEntity.noContent().build();
    }

}
