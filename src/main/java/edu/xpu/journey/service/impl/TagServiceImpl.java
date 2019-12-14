package edu.xpu.journey.service.impl;

import com.google.common.collect.Lists;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 长林
 */
@Service
public class TagServiceImpl implements TagService {
    private final TagInfoMapper tagInfoMapper;
    private final ArticleInfoMapper articleInfoMapper;

    public TagServiceImpl(TagInfoMapper tagInfoMapper, ArticleInfoMapper articleInfoMapper) {
        this.tagInfoMapper = tagInfoMapper;
        this.articleInfoMapper = articleInfoMapper;
    }

    @Override
    public List<ArticleInfo> getAllArticleForTag(Integer tag) {
        List<Integer> articleIdList = tagInfoMapper.getAllArticlesForTag(tag);
        List<ArticleInfo> articleInfoList = Lists.newArrayListWithCapacity(articleIdList.size());
        for(Integer articleId: articleIdList){
            articleInfoList.add(articleInfoMapper.findOneById(articleId));
        }
        return articleInfoList;
    }

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
        return tagInfoMapper.getAllTagsExcludeArticle(article);
    }

    @Override
    public void setTagsForArticle(Integer article, String tags) {
        ArticleInfo findResult = articleInfoMapper.findOneById(article);
        if(findResult != null){
            String[] tagsArray = tags.split(" ");
            //清空一篇文章的标签
            List<Integer> articleTagPlus = tagInfoMapper.findArticleTagPlus(article);
            for(Integer i:articleTagPlus){
                tagInfoMapper.deleteArticleTag(i);
            }
            try{
                //添加所有标签
                for (String tagId : tagsArray) {
                    tagInfoMapper.addArticleTag(article, Integer.parseInt(tagId));
                }
            }catch (NumberFormatException e){
                //
            }
        }
    }

    @Override
    public void addNewTag(String tagName) {
        tagInfoMapper.insertByObject(new TagInfo().setName(tagName).setAmount(0));
    }

    @Override
    public void updateTag(Integer tagId, String tagName) {
        int updateResult = tagInfoMapper.updateTagInfoById(tagId, tagName);
        assert updateResult == 1;
    }

    @Override
    public void deleteTagById(Integer tagId) {
        tagInfoMapper.deleteTagInfo(tagId);
    }
}
