package edu.xpu.journey.dao;

import edu.xpu.journey.entity.CategoryInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryInfoRepositoryTest {
    @Autowired
    private CategoryInfoRepository categoryInfoRepository;

    @Test
    public void save(){
        CategoryInfo categoryInfo = new CategoryInfo();
        categoryInfo.setMyname("Java核心技术");
        categoryInfo.setDescribes("包含JVM、Java并发编程等内容");
        categoryInfo.setAmount(0);

        CategoryInfo save = categoryInfoRepository.save(categoryInfo);
        assertNotNull(save);
    }
}