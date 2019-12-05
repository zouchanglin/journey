package edu.xpu.journey.entity.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import edu.xpu.journey.entity.TagInfo;
import org.springframework.stereotype.Repository;

/**
 * 标签的CRUD
 * @author 长林
 */
@Repository
public interface TagInfoMapper {

	/**
	 * 获取一篇文章的标签信息集合
	 * @param article 文章的编号
	 * @return 标签集合
	 */
	@Select("select a.id,a.name,a.amount from tag_info a right join article_tag b on a.id=b.tag where b.article=#{article}")
	List<TagInfo> findArticleTags(Integer article);

	/**
	 * 获取所有标签
	 * @return 标签信息集合
	 */
	@Select("select * from tag_info")
	List<TagInfo> getAllTags();
	/**
	 * Map形式插入一条标签信息
	 * @param map Map参数
	 * @return 插入结果
	 */
	@Insert("insert into tag_info(name, amount) values (#{name, jdbcType=VARCHAR}, #{amount, jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> map);

	/**
	 * 获取不包含此篇文章的标签
	 * @param article 文章编号
	 * @return 标签列表
	 */
	@Select("select a.id, a.name, a.amount from tag_info a left join (select * from article_tag where article = #{article}) b on a.id=b.tag where b.tag is null;")
	List<TagInfo> getAllTagsExcludeArticle(Integer article);

	/**
	 * 对象形式插入一条标签信息
	 * @param tagInfo 需要存储的对象
	 * @return 插入结果
	 */
	@Insert("insert into tag_info(name, amount) values (#{name, jdbcType=VARCHAR}, #{amount, jdbcType=INTEGER})")
	int insertByObject(TagInfo tagInfo);

	/**
	 * 更新标签信息
	 * @param name 标签名称
	 * @param amount 标签下文章数
	 * @param id 标签的Id
	 * @return 更新结果
	 */
	@Update("update tag_info set name=#{name}, amount=#{amount} where id=#{id}")
	int updateTagInfo(@Param("name") String name, @Param("amount")Integer amount,@Param("id") Integer id);

	/**
	 * 直接传对象更改标签信息
	 * @param tagInfo 标签对象
	 * @return 更新结果
	 */
	@Update("update tag_info set name=#{name}, amount=#{amount} where id=#{id}")
	int updateTagInfoByObject(TagInfo tagInfo);

	/**
	 * 删除一条标签
	 * @param id 标签编号
	 * @return 删除结果
	 */
	@Delete("delete from tag_info where id=#{id}")
	int deleteTagInfo(Integer id);


	//更新一条记录（文章+标签）
	@Update("update article_tag set article=#{article}, tag=#{tag} where id=#{id}")
	int updateArticleTag(Integer id, Integer article, Integer tag);

	@Insert("insert into article_tag(article, tag) values (#{article, jdbcType=INTEGER}, #{tag, jdbcType=INTEGER})")
	void addArticleTag(Integer article, Integer tag);

	@Select("select id from article_tag where article = #{article} and tag = #{tag}")
	Integer findArticleTag(Integer article, Integer tag);

	@Select("select id from article_tag where article = #{article}")
	List<Integer> findArticleTagPlus(Integer article);

	@Delete("delete from article_tag where id=#{id}")
	void deleteArticleTag(Integer id);
}