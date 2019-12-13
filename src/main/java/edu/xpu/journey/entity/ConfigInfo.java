package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
public class ConfigInfo {
    @Id
    private String menu;
    private String param;
    private String argument;
}
