package com.es.search.controller.admin;

import com.es.search.common.AdminPermission;
import com.es.search.common.BusinessException;
import com.es.search.common.CommonUtil;
import com.es.search.common.EmBusinessError;
import com.es.search.model.CategoryModel;
import com.es.search.model.SellerModel;
import com.es.search.request.CategoryCreateReq;
import com.es.search.request.PageQuery;
import com.es.search.request.SellerCreateReq;
import com.es.search.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @description todo
 * @date 2021/1/23 5:26 下午
 */
@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateReq categoryCreateReq, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryCreateReq.getName());
        categoryModel.setIconUrl(categoryCreateReq.getIconUrl());
        categoryModel.setSort(categoryCreateReq.getSort());
        categoryService.create(categoryModel);
        return "redirect:/admin/category/index";
    }


    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery){
        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<CategoryModel> categoryModels = categoryService.selectAll();
        PageInfo<CategoryModel> pageInfo = new PageInfo<>(categoryModels);
        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data",pageInfo);
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }
}
