package edu.xpu.journey.entity;

import lombok.Data;

/**
 * 文章实体类
 * @author 长林
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String tittle;
    private String summary;
    private String content;
    private String picture;
    private Integer reading;
    private Integer love;
    private Integer discuss;
    private Integer status;
    private Integer category;
    private Long creatime;
    private Long updatime;
}
