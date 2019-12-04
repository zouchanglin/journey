package edu.xpu.journey.entity.mapper;

import edu.xpu.journey.entity.LinkInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LinkInfoMapperTest {
    @Autowired
    private LinkInfoMapper linkInfoMapper;

    @Test
    public void selectOneById() {
        LinkInfo findResult = linkInfoMapper.selectOneById(1);
        assertNotNull(findResult);
    }
}