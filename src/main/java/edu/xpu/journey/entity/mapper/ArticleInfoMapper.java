package edu.xpu.journey.entity.mapper;

import edu.xpu.journey.entity.ArticleInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 长林
 */
public interface ArticleInfoMapper {
    /**
     * 根据状态获取所有文章
     * @param status 状态参数
     * @return 文章列表
     */
    @Select("select * from article_info where status=#{status}")
    List<ArticleInfo> findAllByStatus(Integer status);

    /**
     * 根据文章编号查找文章
     * @param id 文章编号
     * @return 文章对象
     */
    @Select("select * from article_info where id=#{id}")
    ArticleInfo findOneById(Integer id);

    /**
     * 根据状态分页查询
     * @param status 文章的状态
     * @param start 起始位置
     * @param pageSize  页容量
     * @return 文章查询结果
     */
    @Select("select * from article_info where status=#{status} limit #{start}, #{pageSize}")
    List<ArticleInfo> findPageByStatus(Integer status, Integer start, Integer pageSize);

    /**
     * 删除一篇文章
     * @param id 文章id
     * @return 删除结果
     */
    @Delete("delete from article_info where id=#{id}")
    int deleteArticle(Integer id);

    /**
     * 修改文章
     * @param articleInfo 文章实体对象
     * @return 修改结果
     */
    @Update("update article_info set tittle=#{tittle}, summary=#{summary}, " +
            "content=#{content}, " +
            "reading=#{reading}, love=#{love}, " +
            "discuss=#{discuss}, status=#{status}, " +
            "category=#{category}, creatime=#{creatime}, updatime=#{updatime} " +
            "where id=#{id}")
    int updateArticleInfoByObject(ArticleInfo articleInfo);


    /**
     * 修改阅读量（经常修改）
     * @param reading 阅读统计
     * @param id 文章编号
     * @return 修改结果
     */
    @Update("update article_info set reading=#{reading} where id=#{id}")
    int updateArticleReading(Integer reading, Integer id);

    /**
     * 更改文章状态
     * @param status 目标状态
     * @param id 文章编号
     * @return 更改结果
     */
    @Update("update article_info set status=#{status} where id=#{id}")
    int updateArticleStatus(Integer status, Integer id);

    /**
     * 插入一篇文章
     * @param articleInfo 文章对象
     * @return 保存结果
     */
    @Insert("insert into article_info(tittle, summary, content, picture, reading, " +
            "love, discuss, status, category, creatime, updatime) values (" +
            "#{tittle, jdbcType=VARCHAR}, #{summary, jdbcType=VARCHAR}," +
            "#{content, jdbcType=LONGVARCHAR}, " +
            "#{reading, jdbcType=INTEGER}, #{love, jdbcType=INTEGER}," +
            "#{discuss, jdbcType=INTEGER}, #{status, jdbcType=TINYINT}," +
            "#{category, jdbcType=INTEGER}, #{creatime, jdbcType=BIGINT}, #{updatime, jdbcType=BIGINT}) ")
    int insertArticleInfo(ArticleInfo articleInfo);


    @Select("select count(id) from article_info where status=#{status}")
    int countArticleByStatus(Integer status);
}
