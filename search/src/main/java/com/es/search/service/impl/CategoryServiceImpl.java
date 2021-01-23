package com.es.search.service.impl;

import com.es.search.dal.CategoryModelMapper;
import com.es.search.model.CategoryModel;
import com.es.search.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description todo
 * @date 2021/1/23 5:23 下午
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryModelMapper categoryModelMapper;

    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        return get(categoryModelMapper.insert(categoryModel));
    }

    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryModelMapper.selectCount();
    }
}
