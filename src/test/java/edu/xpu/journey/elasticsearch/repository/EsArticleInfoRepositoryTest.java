package edu.xpu.journey.elasticsearch.repository;


import edu.xpu.journey.elasticsearch.entity.EsArticleInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsArticleInfoRepositoryTest {
    @Autowired
    private EsArticleInfoRepository esArticleInfoRepository;
    @Before
    public void init(){
        esArticleInfoRepository.deleteAll();
        esArticleInfoRepository.save(new EsArticleInfo().setTittle("AAA").setSummary("ABC").setContent("CCC"));
        esArticleInfoRepository.save(new EsArticleInfo().setTittle("AAA").setSummary("BBB").setContent("CCC"));
        esArticleInfoRepository.save(new EsArticleInfo().setTittle("CVC").setSummary("AS").setContent("XXX"));
    }

    @Test
    public void findDistinctByTittleContainingOrSummaryContainingOrContentContaining() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<EsArticleInfo> containing = esArticleInfoRepository.
                findDistinctByTittleContainingOrSummaryContainingOrContentContaining(
                        "A", "X", "E", pageRequest);
        assertEquals(2, containing.getContent().size());
    }
}