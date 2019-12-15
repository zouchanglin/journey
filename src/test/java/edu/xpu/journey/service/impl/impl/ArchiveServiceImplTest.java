package edu.xpu.journey.service.impl.impl;

import edu.xpu.journey.service.ArchiveService;
import edu.xpu.journey.vo.ArchiveVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArchiveServiceImplTest {
    @Autowired
    private ArchiveService archiveService;

    @Test
    public void getArchiveData() {
        List<ArchiveVO> archiveData = archiveService.getArchiveData();
        for (ArchiveVO archiveVO: archiveData){
            log.info("[ArchiveServiceImplTest] getArchiveData() archiveVO={}", archiveVO.getTimeStr());
        }
    }
}