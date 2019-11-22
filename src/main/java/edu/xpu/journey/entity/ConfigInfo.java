package edu.xpu.journey.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 系统参数实体类
 * @author 长林
 */
@Data
@Entity
@DynamicUpdate
public class ConfigInfo {
    @Id
    private String menu;

    private Integer param;
    private String argument;
}
