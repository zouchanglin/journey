package edu.xpu.journey.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 分类信息实体
 * @author 长林
 */
@Data
@Entity
@DynamicUpdate
@Accessors(chain = true)
public class CategoryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String myname;
    private String describes;
    private Integer amount;
}
