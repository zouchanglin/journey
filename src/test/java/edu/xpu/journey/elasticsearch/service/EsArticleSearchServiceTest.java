package edu.xpu.journey.elasticsearch.service;


import edu.xpu.journey.entity.ArticleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class EsArticleSearchServiceTest {
    @Autowired
    private EsArticleSearchService searchService;
    @Test
    public void searchKeyWord() {
        List<ArticleInfo> articleInfoList = searchService.searchKeyWord("连接");
        System.out.println(articleInfoList);
    }
}