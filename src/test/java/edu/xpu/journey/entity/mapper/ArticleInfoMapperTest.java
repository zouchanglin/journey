package edu.xpu.journey.entity.mapper;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleTopEnum;
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
    //更新文章信息测试
    @Test
    public void updateArticleInfoByObject(){

        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(4);
        articleInfo.setTittle("CCC");
        articleInfo.setSummary("CCC");
        articleInfo.setContent("CCC");

        articleInfo.setCategory(0);
        articleInfo.setDiscuss((int)(Math.random() * 100));
        articleInfo.setReading((int)(Math.random() * 100));
        articleInfo.setLove((int)(Math.random() * 100));
        articleInfo.setStatus(0);
        articleInfo.setCreatime(System.currentTimeMillis());
        articleInfo.setUpdatime(System.currentTimeMillis());

        int result = mapper.updateArticleInfoByObject(articleInfo);
        assertEquals(1, result);
    }


    @Test
    public void insertArticleInfo(){
        for (int i = 0; i < 20; i++) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setTittle("Tittle"+i)
                    .setSummary("Summary"+i)
            .setContent("Content"+i)
            .setCategory(i % 6 + 1)
            .setDiscuss(i)
            .setReading(i)
            .setLove(i)
            .setStatus(i % 2 + 1)
            .setCreatime(System.currentTimeMillis())
            .setUpdatime(System.currentTimeMillis())
            .setTop(ArticleTopEnum.NO_TOP.getCode());
            System.out.println(articleInfo);
            int result = mapper.insertArticleInfo(articleInfo);
            assertEquals(1, result);
        }

    }

    @Test
    public void findAllByStatus(){
        List<ArticleInfo> allByStatus = mapper.findAllByStatus(0);
        assertEquals(2, allByStatus.size());
    }

    @Test
    public void findNewestArticleIdByUpdatime(){
        Integer updatime = mapper.findNewestArticleIdByUpdatime();
        assertEquals(253, updatime);
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