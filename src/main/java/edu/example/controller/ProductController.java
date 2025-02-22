package edu.example.controller;

import edu.example.model.Product;
import edu.example.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    final ProductService productService;

    @PostMapping("/save_product")
    public ResponseEntity<String> saveProduct(@RequestBody Product product, HttpServletRequest request) {
        if(Boolean.TRUE.equals(productService.saveProduct(product))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Family detail: {}", os,product);
            return ResponseEntity.ok("family added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added family");
        }
    }

    @PutMapping("/update_product")
    public ResponseEntity<String> updateProduct( @RequestBody Product product,
                                               HttpServletRequest request){
        if(Boolean.TRUE.equals(productService.updateProduct(product))) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | update family detail: {}", os, product);
            return ResponseEntity.ok("family update successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't family person");
        }
    }
}
