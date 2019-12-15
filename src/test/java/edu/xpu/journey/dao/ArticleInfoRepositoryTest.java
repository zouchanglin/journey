package edu.xpu.journey.dao;


import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.enums.ArticleStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArticleInfoRepositoryTest {
//    @Autowired
//    private ArticleInfoRepository articleInfoRepository;
//
//    @Before
//    public void init(){
//
//    }
//
//    @Test
//    public void find(){
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        Page<ArticleInfo> ret = articleInfoRepository.findAllByStatusOrderByCreatime(ArticleStatusEnum.RELEASE.getCode(), pageRequest);
//        log.info("[ArticleInfoRepositoryTest] find() ret={}", ret);
//    }

}