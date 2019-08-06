package com.czxy.controller;

import com.czxy.domain.PCD;
import com.czxy.service.PCDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pcd")
public class PCDController {
    @Resource
    private PCDService pcdService;

    @GetMapping("/findAllProvince")
    public ResponseEntity<List<PCD>> findAllProvince(){
        List<PCD> all = pcdService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<List<PCD>> findById(@PathVariable("id") String id){
        List<PCD> all = pcdService.findById(id);
        return ResponseEntity.ok(all);
    }
}
