package edu.xpu.journey.dao;

import edu.xpu.journey.entity.DiscussInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DiscussInfoRepositoryTest {
    @Autowired
    private DiscussInfoRepository discussInfoRepository;

    @Test
    public void save(){
        DiscussInfo discussInfo = new DiscussInfo();
        discussInfo.setCreatime(System.currentTimeMillis());
        discussInfo.setBrowser("Mozilla/5.0");
        discussInfo.setOsystem("Windows NT 6.3; Win64; x64");
        discussInfo.setContent("AAAAAAAAAAA");
        discussInfo.setEmail("1529191@qq.com");
        discussInfo.setWebsite("http://baidu.com");
        discussInfo.setArticle(1);
        discussInfo.setReply(1);
        assertNotNull(discussInfoRepository.save(discussInfo));
    }
}