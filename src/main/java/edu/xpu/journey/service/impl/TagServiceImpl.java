package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.service.TagService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    @Override
    public List<TagInfo> getOtherTags(Integer article) {
        HashSet<TagInfo> h1 = new HashSet<>(tagInfoMapper.getAllTags());
        HashSet<TagInfo> h2 = new HashSet<>(tagInfoMapper.findArticleTags(article));
        h1.removeAll(h2);
        List<TagInfo> surplus = Lists.newArrayList();
        surplus.addAll(h1);
        return surplus;
    }
}
