package com.czxy.service;

import com.czxy.domain.Category;

import java.util.List;

public interface CategoryService {


    public List<Category> findAll();
    public Category findById(String cid);

}
