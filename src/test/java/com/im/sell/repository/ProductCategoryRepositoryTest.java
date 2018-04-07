package com.im.sell.repository;

import com.im.sell.dataObject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void saveTest(){
        Optional<ProductCategory> tmp = repository.findById(1);
        ProductCategory productCategory = tmp.get();
        productCategory.setCategoryType(8);
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(1);
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

}