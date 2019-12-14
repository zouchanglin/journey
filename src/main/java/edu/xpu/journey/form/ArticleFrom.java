package edu.xpu.journey.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 前端传后台的文章信息表单
 * @author 长林
 */
@Data
public class ArticleFrom {
    @NotNull
    private String tittle;
    private String summary;
    @NotNull
    private String content;
    @NotNull
    private Integer category;
    private String tags;
}
