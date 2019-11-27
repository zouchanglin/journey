package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.form.ArticleFrom;
import edu.xpu.journey.service.ArticleService;
import edu.xpu.journey.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 长林
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private TagService tagService;


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
        int saveResult = 0;

        if(findArticleInfo != null){
            //修改已有文章并发布
            saveArticleInfo.setId(article);
            saveArticleInfo.setLove(findArticleInfo.getLove());
            saveArticleInfo.setReading(findArticleInfo.getLove());
            saveArticleInfo.setDiscuss(findArticleInfo.getDiscuss());
            saveArticleInfo.setCreatime(findArticleInfo.getCreatime());

            saveResult = articleInfoMapper.updateArticleInfoByObject(saveArticleInfo);
            log.info("[ArticleServiceImpl] releaseArticle() saveResult={}", saveResult);
        }else{
            //直接写的新文章发布
            saveArticleInfo.setLove(0);
            saveArticleInfo.setReading(0);
            saveArticleInfo.setDiscuss(0);
            saveArticleInfo.setCreatime(System.currentTimeMillis());

            saveResult = articleInfoMapper.insertArticleInfo(saveArticleInfo);
            log.info("[ArticleServiceImpl] releaseArticle() saveResult={}", saveResult);
        }

        return saveResult == 1 ? saveArticleInfo:null;
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