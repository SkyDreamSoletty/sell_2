package com.im.sell.service.impl;

import com.im.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    @Transactional
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals("最爱",productCategory.getCategoryName());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("美味海鲜",8);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}