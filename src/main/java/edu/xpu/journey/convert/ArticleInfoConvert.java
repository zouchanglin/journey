package edu.xpu.journey.convert;

import com.google.common.collect.Lists;
import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.VO.ArticleInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author x
 */
@Service
@Slf4j
public class ArticleInfoConvert {
    private final CategoryInfoRepository categoryRepository;
    private final TagInfoMapper tagInfoMapper;

    public ArticleInfoConvert(CategoryInfoRepository categoryRepository,
                              TagInfoMapper tagInfoMapper) {
        this.categoryRepository = categoryRepository;
        this.tagInfoMapper = tagInfoMapper;
    }


    public List<ArticleInfoVO> convertList(List<ArticleInfo> list){
        List<ArticleInfoVO> ret = Lists.newArrayList();
        for(ArticleInfo articleInfo: list){
            ret.add(articleToStr(articleInfo));
        }
        return ret;
    }

    public ArticleInfoVO articleToStr(ArticleInfo articleInfo){
        log.info("[ArticleInfoConvert] articleToStr() articleInfo={}", articleInfo);
        ArticleInfoVO articleInfoShow = new ArticleInfoVO(articleInfo);

        //时间格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        articleInfoShow.setCreatimeStr(dateFormat.format(new Date(articleInfo.getCreatime())));
        articleInfoShow.setUpdatimeStr(dateFormat.format(new Date(articleInfo.getUpdatime())));

        //查询分类字符串
        Integer categoryId = articleInfo.getCategory();
        Optional<CategoryInfo> findResult = categoryRepository.findById(categoryId);
        findResult.ifPresent(categoryInfo -> articleInfoShow.setCategoryStr(categoryInfo.getMyname()));

        //查询标签字符串
        List<TagInfo> articleTags = tagInfoMapper.findArticleTags(articleInfo.getId());
        List<String> tagNames=articleTags.stream().map(TagInfo::getName).collect(Collectors.toList());
        articleInfoShow.setTagArrayStr(tagNames);
        log.info("[ArticleInfoConvert] articleToStr() articleInfoShow={}", articleInfoShow);
        return articleInfoShow;
    }
}