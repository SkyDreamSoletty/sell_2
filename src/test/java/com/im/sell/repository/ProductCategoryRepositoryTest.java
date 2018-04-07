package com.im.sell.repository;

import com.im.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory);
        System.out.println(productCategory.get());
    }

    @Test
    @Transactional//完全回滚 不会在数据库添加测试数据
    public void saveTest(){
//        Optional<ProductCategory> tmp = repository.findById(1);
//        ProductCategory productCategory = tmp.get();
//        productCategory.setCategoryType(5);
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(1);
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(2);
//        repository.save(productCategory);
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> categoryTypeList = Arrays.asList(1,2,3,4,8);
        List<ProductCategory> result = repository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0,result.size());
    }

}