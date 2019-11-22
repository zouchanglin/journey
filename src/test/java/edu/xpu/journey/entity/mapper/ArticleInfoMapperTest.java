package edu.xpu.journey.entity.mapper;

import edu.xpu.journey.entity.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArticleInfoMapperTest {
    @Autowired
    private ArticleInfoMapper mapper;

    @Test
    public void deleteArticle(){
        int deleteResult = mapper.deleteArticle(3);
        assertEquals(1, deleteResult);
    }

    @Test
    public void updateArticleReading(){
        int ret = mapper.updateArticleReading(111, 1);
        assertEquals(1, ret);
    }

    @Test
    public void updateArticleInfoByObject(){
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(4);
        articleInfo.setTittle("CCC");
        articleInfo.setSummary("CCC");
        articleInfo.setContent("CCC");
        articleInfo.setPicture("CCC");
        articleInfo.setCategory(0);
        articleInfo.setDiscuss(0);
        articleInfo.setReading(120);
        articleInfo.setLove(0);
        articleInfo.setStatus(0);
        articleInfo.setCreatime(System.currentTimeMillis());
        articleInfo.setUpdatime(System.currentTimeMillis());

        int result = mapper.updateArticleInfoByObject(articleInfo);
        assertEquals(1, result);
    }


    @Test
    public void insertArticleInfo(){
        ArticleInfo articleInfo = new ArticleInfo();
        //articleInfo.setId(1);
        articleInfo.setTittle("CCC");
        articleInfo.setSummary("BBB");
        articleInfo.setContent("CCC");
        articleInfo.setPicture("DDD");
        articleInfo.setCategory(0);
        articleInfo.setDiscuss(0);
        articleInfo.setReading(0);
        articleInfo.setLove(0);
        articleInfo.setStatus(0);
        articleInfo.setCreatime(System.currentTimeMillis());
        articleInfo.setUpdatime(System.currentTimeMillis());

        int result = mapper.insertArticleInfo(articleInfo);
        assertEquals(1, result);
    }

    @Test
    public void findAllByStatus(){
        List<ArticleInfo> allByStatus = mapper.findAllByStatus(0);
        assertEquals(2, allByStatus.size());
    }

    /**
     * 分页查询测试
     */
    @Test
    public void findPageByStatus(){
        Integer page = 0;
        Integer pageSize = 2;

        Integer start = page * pageSize;
        List<ArticleInfo> allByStatus = mapper.findPageByStatus(0, start, pageSize);
        assertEquals(2, allByStatus.size());
    }
}