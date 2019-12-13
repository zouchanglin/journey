package edu.xpu.journey.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author x
 */
@Data
@Accessors(chain = true)
@Document(indexName = "article", type = "article")
public class EsArticleInfo implements Serializable {
    private static final long serialVersionUID = 2404819559774004630L;
    @Id
    private Integer id;
    private String tittle;
    private String summary;
    private String content;
}
