package edu.xpu.journey.VO;

import edu.xpu.journey.entity.ArticleInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 文章视图对象
 * @author x
 */
@Data
@Accessors(chain = true)
public class ArticleInfoVO {
    private ArticleInfo articleInfo;
    private String creatimeStr;
    private String updatimeStr;
    private String categoryStr;
    private List<String> tagArrayStr;
    public ArticleInfoVO(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }
}
