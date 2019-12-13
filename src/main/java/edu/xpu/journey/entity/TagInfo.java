package edu.xpu.journey.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 标签实体类
 * @author 长林
 */
@Data
@Accessors(chain = true)
public class TagInfo {
	private Integer id;
	private String name;
	private Integer amount;
}
