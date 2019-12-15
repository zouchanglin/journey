package edu.xpu.journey.service.impl;

import edu.xpu.journey.dao.ConfigInfoRepository;
import edu.xpu.journey.dao.DiscussInfoRepository;
import edu.xpu.journey.entity.ConfigInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.CategoryService;
import edu.xpu.journey.service.CountService;
import edu.xpu.journey.service.TagService;
import edu.xpu.journey.vo.SideBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author x
 */
@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private DiscussInfoRepository discussInfoRepository;
    @Autowired
    private ConfigInfoRepository configInfoRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    @Override
    public int getArticleCount() {
        return articleInfoMapper.countArticles();
    }

    @Override
    public int getArticleCountByStatus(Integer articleStatus) {
        return articleInfoMapper.countArticleByStatus(articleStatus);
    }

    @Override
    public long getReadingCount() {
        Long ret = articleInfoMapper.countArticleReadingByStatus(ArticleStatusEnum.RELEASE.getCode());
        return ret == null ? 0:ret;
    }

    @Override
    public int getLoveCount() {
        Integer ret = articleInfoMapper.countArticleLoveByStatus(ArticleStatusEnum.RELEASE.getCode());
        return ret == null ? 0:ret;
    }

    @Override
    public int getDiscussCount() {
        //TODO 只统计发布文章的评论
        return (int)discussInfoRepository.count();
    }

    @Override
    public SideBarVO getCountDataPackage() {
        Optional<ConfigInfo> blogSubtitle = configInfoRepository.findById("blogSubtitle");
        Optional<ConfigInfo> blogTittle = configInfoRepository.findById("blogTittle");



        SideBarVO sideBarVO = new SideBarVO();
        if(blogTittle.isPresent()){
            sideBarVO.setBlogTitle(blogTittle.get().getParam());
        }else{
            sideBarVO.setBlogTitle("");
        }

        if(blogSubtitle.isPresent()){
            sideBarVO.setBlogSubtitle(blogSubtitle.get().getParam());
        }else{
            sideBarVO.setBlogSubtitle("");
        }

        sideBarVO.setCategoryInfoList(categoryService.getAll());
        sideBarVO.setTagInfoList(tagService.getAllTags());
        sideBarVO.setArticleCount(getArticleCountByStatus(ArticleStatusEnum.RELEASE.getCode()));
        sideBarVO.setLoveCount(getLoveCount());
        sideBarVO.setDiscussCount(getDiscussCount());
        sideBarVO.setReadingCount(getReadingCount());

        return sideBarVO;
    }
}
