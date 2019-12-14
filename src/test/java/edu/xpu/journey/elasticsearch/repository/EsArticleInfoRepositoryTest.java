package edu.xpu.journey.elasticsearch.repository;


import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EsArticleInfoRepositoryTest {
    @Autowired
    private EsArticleInfoRepository esArticleInfoRepository;

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
//    @Before
//    public void init(){
//        esArticleInfoRepository.deleteAll();
//        esArticleInfoRepository.save(new EsArticleInfo().setTittle("AAA").setSummary("ABC").setContent("CCC"));
//        esArticleInfoRepository.save(new EsArticleInfo().setTittle("AAA").setSummary("BBB").setContent("CCC"));
//        esArticleInfoRepository.save(new EsArticleInfo().setTittle("CVC").setSummary("AS").setContent("XXX"));
//    }
//    @Test
//    public void initReallyData(){
//        List<ArticleInfo> all = articleInfoMapper.findAll();
//        for(ArticleInfo articleInfo: all){
//            esArticleInfoRepository.save(new EsArticleInfo().setTittle(articleInfo.getTittle())
//            .setContent(articleInfo.getContent()).setSummary(articleInfo.getSummary()));
//        }
//    }
//
//    @Test
//    public void findDistinctByTittleContainingOrSummaryContainingOrContentContaining() {
//        PageRequest pageRequest = PageRequest.of(0, 20);
//        Page<EsArticleInfo> containing = esArticleInfoRepository.
//                findDistinctByTittleContainingOrSummaryContainingOrContentContaining(
//                        "A", "X", "E", pageRequest);
//        assertEquals(2, containing.getContent().size());
//    }

    @Test
    public void initReallyData(){
        esArticleInfoRepository.deleteAll();
        List<ArticleInfo> all = articleInfoMapper.findAll();
        for(ArticleInfo articleInfo: all){
            log.info("save={}", articleInfo.getTittle());
            esArticleInfoRepository.save(articleInfo);
        }
    }
}