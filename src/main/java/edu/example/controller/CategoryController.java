package edu.example.controller;

import edu.example.model.Category;
import edu.example.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@CrossOrigin
@Slf4j
public class CategoryController {
    final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody Category category, HttpServletRequest request) {
        if(Boolean.TRUE.equals(categoryService.addCategory(category))) {
            String os = request.getRemoteAddr();
            log.info("request received IP: {} | added category detail: {}", os,category);
            return ResponseEntity.ok("category added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added category");
        }
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id,HttpServletRequest request){
        if (categoryService.deleteCategory(id)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | delete category id: {}", os,id );
            return ResponseEntity.ok("product category successfully");
        }else{
            return ResponseEntity.internalServerError().body("try again! , can't delete category");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> list = categoryService.getAllCategory();
        if (list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
