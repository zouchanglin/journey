package edu.xpu.journey.service.impl;

import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 长林
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagInfoMapper tagInfoMapper;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

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
        //原来的查找方式
        // HashSet<TagInfo> h1 = new HashSet<>(tagInfoMapper.getAllTags());
        // HashSet<TagInfo> h2 = new HashSet<>(tagInfoMapper.findArticleTags(article));
        // h1.removeAll(h2);
        // List<TagInfo> surplus = Lists.newArrayList();
        // surplus.addAll(h1);
        // return surplus;
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
}
