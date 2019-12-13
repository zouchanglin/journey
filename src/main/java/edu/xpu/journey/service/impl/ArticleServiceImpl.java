package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.enums.ArticleTopEnum;
import edu.xpu.journey.form.ArticleFrom;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 长林
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    private final ArticleInfoMapper articleInfoMapper;
    private final TagService tagService;

    public ArticleServiceImpl(ArticleInfoMapper articleInfoMapper, TagService tagService) {
        this.articleInfoMapper = articleInfoMapper;
        this.tagService = tagService;
    }


    @Override
    public ArticleInfo getArticleById(Integer articleId) {
        return articleInfoMapper.findOneById(articleId);
    }

    @Override
    public Integer getArticleCountByStatus(Integer status) {
        return articleInfoMapper.countArticleByStatus(status);
    }

    @Transactional
    @Override
    public ArticleInfo saveManuscript(Integer article, ArticleFrom articleFrom) {
        return saveArticleInfo(article, articleFrom, ArticleStatusEnum.DEBUG.getCode());
    }

    @Transactional
    @Override
    public ArticleInfo releaseArticle(Integer article, ArticleFrom articleFrom) {
        return saveArticleInfo(article, articleFrom, ArticleStatusEnum.RELEASE.getCode());
    }

    @Override
    public List<ArticleInfo> getPageArticleList(Integer status, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articleInfoMapper.findPageByStatus(status, start, pageSize);
    }

    @Override
    public void articleToRecycle(Integer articleId) {
        int updateResult = articleInfoMapper.updateArticleStatus(ArticleStatusEnum.DELETE.getCode(), articleId);
        log.info("[ArticleServiceImpl] articleToRecycle updateResult={}", updateResult);
    }

    private ArticleInfo saveArticleInfo(Integer article, ArticleFrom articleFrom, Integer status) {
        ArticleInfo findArticleInfo = articleInfoMapper.findOneById(article);
        ArticleInfo saveArticleInfo = new ArticleInfo();
        BeanUtils.copyProperties(articleFrom, saveArticleInfo);
        saveArticleInfo.setStatus(status);
        saveArticleInfo.setUpdatime(System.currentTimeMillis());
        //处理 Tags
        tagService.setTagsForArticle(article, articleFrom.getTags());
        int saveResult;

        if(findArticleInfo != null){
            //修改已有文章并发布
            saveArticleInfo.setId(article).setLove(findArticleInfo.getLove())
            .setReading(findArticleInfo.getLove()).setDiscuss(findArticleInfo.getDiscuss())
            .setCreatime(findArticleInfo.getCreatime()).setTop(findArticleInfo.getTop());
            saveResult = articleInfoMapper.updateArticleInfoByObject(saveArticleInfo);
        }else{
            //直接写的新文章发布
            saveArticleInfo.setLove(0).setReading(0).setDiscuss(0)
            .setTop(ArticleTopEnum.NO_TOP.getCode())
            .setCreatime(System.currentTimeMillis());
            saveResult = articleInfoMapper.insertArticleInfo(saveArticleInfo);
        }
        log.info("[ArticleServiceImpl] releaseArticle() saveResult={}", saveResult);
        ArticleInfo savedArticleInfo = articleInfoMapper.findOneById(articleInfoMapper.findNewestArticleIdByUpdatime());
        log.info("[ArticleServiceImpl] releaseArticle() savedArticleInfo={}", savedArticleInfo);
        return saveResult == 1 ? savedArticleInfo:null;
    }

    @Override
    public void articleToManuscript(Integer articleId) {
        int updateResult = articleInfoMapper.updateArticleStatus(ArticleStatusEnum.DEBUG.getCode(), articleId);
        log.info("[ArticleServiceImpl] articleToManuscript updateResult={}", updateResult);
    }

    @Override
    public void reallyDelete(Integer article) {
        articleInfoMapper.deleteArticle(article);
    }

    @Override
    public void releaseArticleByManuscript(Integer article) {
        ArticleInfo articleInfo = articleInfoMapper.findOneById(article);
        articleInfo.setStatus(ArticleStatusEnum.RELEASE.getCode());
        articleInfoMapper.updateArticleInfoByObject(articleInfo);
    }
}