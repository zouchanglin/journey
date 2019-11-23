package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagInfoMapper tagInfoMapper;

    @Override
    public List<TagInfo> getArticleTag(Integer article) {
        return tagInfoMapper.findArticleTags(article);
    }

    @Override
    public List<TagInfo> getAllTags() {
        return tagInfoMapper.getAllTags();
    }
}
