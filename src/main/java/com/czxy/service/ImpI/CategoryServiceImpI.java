package com.czxy.service.ImpI;

import com.czxy.dao.CategoryMapper;
import com.czxy.domain.Category;
import com.czxy.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpI implements CategoryService {


    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {

        List<Category> categories = categoryMapper.selectAll();

        return categories;

    }

    @Override
    public Category findById(String cid) {
        return categoryMapper.selectByPrimaryKey(cid);
    }
}
