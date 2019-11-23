package edu.xpu.journey.show;

import edu.xpu.journey.entity.ArticleInfo;
import lombok.Data;

@Data
public class ArticleInfoShow {
    private ArticleInfo articleInfo;
    private String creatimeStr;
    private String updatimeStr;
    private String categoryStr;
    private String[] tagArrayStr;
    public ArticleInfoShow(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }
}
