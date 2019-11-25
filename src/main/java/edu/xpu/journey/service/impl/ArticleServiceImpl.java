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

    //TODO 事务支持
    @Override
    public Boolean releaseArticle(Integer article, ArticleFrom articleFrom) {
        ArticleInfo findArticleInfo = articleInfoMapper.findOneById(article);

        ArticleInfo saveArticleInfo = new ArticleInfo();
        BeanUtils.copyProperties(articleFrom, saveArticleInfo);
        saveArticleInfo.setStatus(ArticleStatusEnum.RELEASE.getCode());
        saveArticleInfo.setUpdatime(System.currentTimeMillis());
        //处理 Tags
        tagService.setTagsForArticle(article, articleFrom.getTags());

        if(findArticleInfo != null){
            //修改已有文章并发布
            saveArticleInfo.setId(article);
            saveArticleInfo.setLove(findArticleInfo.getLove());
            saveArticleInfo.setReading(findArticleInfo.getLove());
            saveArticleInfo.setDiscuss(findArticleInfo.getDiscuss());
            saveArticleInfo.setCreatime(findArticleInfo.getCreatime());

            int saveResult = articleInfoMapper.updateArticleInfoByObject(saveArticleInfo);
            log.info("[ArticleServiceImpl] releaseArticle() saveResult={}", saveResult);
            return saveResult == 1;
        }else{
            //直接写的新文章发布
            saveArticleInfo.setLove(0);
            saveArticleInfo.setReading(0);
            saveArticleInfo.setDiscuss(0);
            saveArticleInfo.setCreatime(System.currentTimeMillis());

            int saveResult = articleInfoMapper.insertArticleInfo(saveArticleInfo);
            log.info("[ArticleServiceImpl] releaseArticle() saveResult={}", saveResult);
            return saveResult == 1;
        }
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
}
