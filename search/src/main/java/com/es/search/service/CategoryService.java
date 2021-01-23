package com.es.search.service;

import com.es.search.model.CategoryModel;

import java.util.List;

/**
 * @description todo
 * @date 2021/1/23 5:21 下午
 */
public interface CategoryService {
    CategoryModel create(CategoryModel categoryModel);
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();
}
