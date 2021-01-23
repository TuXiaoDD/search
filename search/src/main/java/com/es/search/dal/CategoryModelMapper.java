package com.es.search.dal;

import com.es.search.model.CategoryModel;

import java.util.List;

public interface CategoryModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    int insert(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    int insertSelective(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    CategoryModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    int updateByPrimaryKeySelective(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Sat Jan 23 17:18:06 CST 2021
     */
    int updateByPrimaryKey(CategoryModel record);

    List<CategoryModel> selectAll();
}