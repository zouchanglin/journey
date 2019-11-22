package edu.xpu.journey.show;

import com.google.common.collect.Lists;
import edu.xpu.journey.entity.ArticleInfo;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.List;

@Getter
public class StrArticleInfo {
    private ArticleInfo articleInfo;
    private String creatimeStr;
    private String updatimeStr;

    public void setArticleInfo(ArticleInfo articleInfo){
        this.articleInfo = articleInfo;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.creatimeStr = dateFormat.format(articleInfo.getCreatime());
        this.updatimeStr = dateFormat.format(articleInfo.getUpdatime());
    }

    public static List<StrArticleInfo> convert(List<ArticleInfo> list){
        List<StrArticleInfo> ret = Lists.newArrayList();
        for(ArticleInfo articleInfo: list){
            StrArticleInfo strArticleInfo = new StrArticleInfo();
            strArticleInfo.setArticleInfo(articleInfo);
            ret.add(strArticleInfo);
        }
        return ret;
    }
}
