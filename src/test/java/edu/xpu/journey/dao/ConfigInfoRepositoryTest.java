package edu.xpu.journey.dao;

import edu.xpu.journey.entity.ConfigInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigInfoRepositoryTest {
    @Autowired
    private ConfigInfoRepository configInfoRepository;

    @Test
    public void save(){
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setMenu("pageSize");
        configInfo.setParam("20");
        configInfo.setArgument("每页的文章数量");
        assertNotNull(configInfoRepository.save(configInfo));
    }
}