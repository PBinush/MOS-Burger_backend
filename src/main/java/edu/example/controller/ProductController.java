package edu.example.controller;

import edu.example.model.Product;
import edu.example.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product product, HttpServletRequest request) {
        if(Boolean.TRUE.equals(productService.saveProduct(product))) {
            String os = request.getRemoteAddr();
            log.info("request received IP: {} | added product detail: {}", os,product);
            return ResponseEntity.ok("product added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added product");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct( @RequestBody Product product,
                                               HttpServletRequest request){
        if(Boolean.TRUE.equals(productService.updateProduct(product))) {
            String os = request.getRemoteAddr();
            log.info("request received IP: {} | update product detail: {}", os, product);
            return ResponseEntity.ok("product update successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't update person");
        }
    }

//    @GetMapping("/get-by-category/{category}")
//    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
//        List<Product> productByCategory = productService.getProductByCategory(category);
//        if (productByCategory!=null){
//            return new ResponseEntity<>(productByCategory,HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
        List<Product> productByCategory = productService.getProductByName(name);
        if (productByCategory!=null){
            return new ResponseEntity<>(productByCategory,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Product productById = productService.getProductById(id);
        if (productById != null){
            return new ResponseEntity<>(productById,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id,HttpServletRequest request){
        if (productService.deleteProduct(id)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | delete product id: {}", os,id );
            return ResponseEntity.ok("product delete successfully");
        }else{
            return ResponseEntity.internalServerError().body("try again! , can't delete product");
        }
    }
}
