package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 评论信息实体类
 * @author 长林
 */
@Data
@Entity
@DynamicUpdate
@Accessors(chain = true)
public class DiscussInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Long creatime;
    private String osystem;
    private String browser;
    private String email;
    private String website;
    private Integer article;
    private Integer reply;
}
