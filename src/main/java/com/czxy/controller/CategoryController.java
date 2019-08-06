package com.czxy.controller;

import com.czxy.domain.Category;
import com.czxy.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Category>> findAll(){
        try {
            List<Category> all = categoryService.findAll();
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByCid/{cid}")
    public ResponseEntity<Category> findByCid(@PathVariable("cid")String cid){
        try {
            Category byId = categoryService.findById(cid);
            return ResponseEntity.ok(byId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
