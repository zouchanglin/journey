package edu.xpu.journey.convert;

import com.google.common.collect.Lists;
import edu.xpu.journey.dao.CategoryInfoRepository;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.CategoryInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.entity.mapper.TagInfoMapper;
import edu.xpu.journey.show.ArticleInfoShow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ArticleInfoConvert {
    @Autowired
    private CategoryInfoRepository categoryRepository;
    @Autowired
    private TagInfoMapper tagInfoMapper;


    public List<ArticleInfoShow> convertList(List<ArticleInfo> list){
        List<ArticleInfoShow> ret = Lists.newArrayList();
        for(ArticleInfo articleInfo: list){
            ret.add(articleToStr(articleInfo));
        }
        return ret;
    }

    public ArticleInfoShow articleToStr(ArticleInfo articleInfo){
        log.info("[ArticleInfoConvert] articleToStr() articleInfo={}", articleInfo);
        ArticleInfoShow articleInfoShow = new ArticleInfoShow(articleInfo);

        //时间格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        articleInfoShow.setCreatimeStr(dateFormat.format(new Date(articleInfo.getCreatime())));
        articleInfoShow.setUpdatimeStr(dateFormat.format(new Date(articleInfo.getUpdatime())));

        //查询分类字符串
        Integer categoryId = articleInfo.getCategory();
        Optional<CategoryInfo> findResult = categoryRepository.findById(categoryId);
        findResult.ifPresent(categoryInfo -> articleInfoShow.setCategoryStr(categoryInfo.getMyname()));

        //查询标签字符串
        List<TagInfo> tagList = tagInfoMapper.findByCategory(categoryId);
        int size = tagList.size();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = tagList.get(i).getName();
        }

        articleInfoShow.setTagArrayStr(arr);
        log.info("[ArticleInfoConvert] articleToStr() articleInfoShow={}", articleInfoShow);
        return articleInfoShow;
    }
}