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
	 * 获取不包含此篇文章的标签
	 * @param article 文章编号
	 * @return 标签列表
	 */
	@Select("select a.id, a.name, a.amount from tag_info a left join (select * from article_tag where article = #{article}) b on a.id=b.tag where b.tag is null;")
	List<TagInfo> getAllTagsExcludeArticle(Integer article);

	/**
	 * 获取一篇文章的标签信息集合
	 * inner join / left join
	 * @param article 文章的编号
	 * @return 标签集合
	 */
	@Select("select a.id,a.name,a.amount from tag_info a left join article_tag b on a.id=b.tag where b.article=#{article}")
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
	 * 只更新标签名称
	 * @param id 标签ID
	 * @param name 标签名称
	 * @return 更新结果
	 */
	@Update("update tag_info set name=#{name} where id=#{id}")
	int updateTagInfoById(Integer id, String name);

	/**
	 * 删除一条标签
	 * @param id 标签编号
	 * @return 删除结果
	 */
	@Delete("delete from tag_info where id=#{id}")
	int deleteTagInfo(Integer id);


	/**
	 * 更新一条记录（文章+标签）, 改用
	 * {@link edu.xpu.journey.entity.mapper.TagInfoMapper} addArticleTag()
	 * @param id 对应关系行ID
	 * @param article 文章ID
	 * @param tag 标签ID
	 * @return 更新结果
	 */
	@Deprecated
	@Update("update article_tag set article=#{article}, tag=#{tag} where id=#{id}")
	int updateArticleTag(Integer id, Integer article, Integer tag);

	/**
	 * 给某篇文章添加标签
	 * @param article 文章ID
	 * @param tag 标签ID
	 */
	@Insert("insert into article_tag(article, tag) values (#{article, jdbcType=INTEGER}, #{tag, jdbcType=INTEGER})")
	void addArticleTag(Integer article, Integer tag);

	/**
	 * 根据文章ID和标签ID返回对应行数据（也就是判断在不在）
	 * @param article 文章ID
	 * @param tag 标签ID
	 * @return 对应行ID
	 */
	@Select("select id from article_tag where article = #{article} and tag = #{tag}")
	Integer findArticleTag(Integer article, Integer tag);

	/**
	 * 获取某个文章的所有标签
	 * @param article 文章ID
	 * @return 标签ID集合
	 */
	@Select("select id from article_tag where article = #{article}")
	List<Integer> findArticleTagPlus(Integer article);

	/**
	 * 文章-标签对应表的删除
	 * @param id 对应行主键
	 */
	@Delete("delete from article_tag where id=#{id}")
	void deleteArticleTag(Integer id);

	/**
	 * 根据标签获取文章ID集合
	 * @param tag 标签ID
	 * @return 文章ID集合
	 */
	@Select("select DISTINCT article from article_tag where tag = #{tag}")
	List<Integer> getAllArticlesForTag(Integer tag);
}