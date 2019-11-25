package edu.xpu.journey.form;

import lombok.Data;

/**
 * 前端传后台的文章信息表单
 * @author 长林
 */
@Data
public class ArticleFrom {
    private String tittle;
    private String summary;
    private String content;
    private Integer category;
    private String tags;
}
