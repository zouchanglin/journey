package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 文章实体类
 * @author 长林
 */
@Data
@Accessors(chain = true)
@Document(indexName = "article", type = "article")
public class ArticleInfo implements Serializable {
    private static final long serialVersionUID = 2404819559774004630L;
    @Id
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
