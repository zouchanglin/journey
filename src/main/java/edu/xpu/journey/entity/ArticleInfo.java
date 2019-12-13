package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章实体类
 * @author 长林
 */
@Data
@Accessors(chain = true)
public class ArticleInfo {
    private Integer id;
    private String tittle;
    private String summary;
    private String content;
    private Integer reading;
    private Integer love;
    private Integer discuss;
    private Integer status;
    private Integer category;
    private Long creatime;
    private Long updatime;
    private Integer top;
}
