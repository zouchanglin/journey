package edu.xpu.journey.entity.mapper;

import edu.xpu.journey.entity.LinkInfo;
import org.springframework.stereotype.Repository;

/**
 * @author 长林
 */
@Repository
public interface LinkInfoMapper {
    LinkInfo selectOneById(Integer id);
}
