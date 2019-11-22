package edu.xpu.journey.entity.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import edu.xpu.journey.entity.TagInfo;

/**
 * 标签的CRUD
 * @author 长林
 */
public interface TagInfoMapper {
	/**
	 * Map形式插入一条标签信息
	 * @param map Map参数
	 * @return 插入结果
	 */
	@Insert("insert into tag_info(name, category, amount) values (#{name, jdbcType=VARCHAR}, #{category, jdbcType=INTEGER}, #{amount, jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> map);

	/**
	 * 对象形式插入一条标签信息
	 * @param tagInfo 需要存储的对象
	 * @return 插入结果
	 */
	@Insert("insert into tag_info(name, category, amount) values (#{name, jdbcType=VARCHAR}, #{category, jdbcType=INTEGER}, #{amount, jdbcType=INTEGER})")
	int insertByObject(TagInfo tagInfo);

	/**
	 * 按照分类查找标签
	 * @param category 分类
	 * @return 分类下的标签集合
	 */
	@Select("select * from tag_info where category = #{category}")
	List<TagInfo> findByCategory(Integer category);

	/**
	 * 更新标签信息
	 * @param name 标签名称
	 * @param category 标签分类
	 * @param amount 标签下文章数
	 * @param id 标签的Id
	 * @return 更新结果
	 */
	@Update("update tag_info set name=#{name}, category=#{category}, amount=#{amount} where id=#{id}")
	int updateTagInfo(@Param("name") String name,@Param("category") Integer category,
					  @Param("amount")Integer amount,@Param("id") Integer id);

	/**
	 * 直接传对象更改标签信息
	 * @param tagInfo 标签对象
	 * @return 更新结果
	 */
	@Update("update tag_info set name=#{name}, category=#{category}, amount=#{amount} where id=#{id}")
	int updateTagInfoByObject(TagInfo tagInfo);

	@Delete("delete from tag_info where id=#{id}")
	int deleteTagInfo(Integer id);
}
