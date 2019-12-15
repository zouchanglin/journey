package edu.xpu.journey.vo;

import edu.xpu.journey.entity.ArticleInfo;
import lombok.Data;

import java.util.List;

/**
 * @author x
 */
@Data
public class ArchiveVO implements Comparable<ArchiveVO>{

    private List<ArticleInfo> articleList;
    //2019年12月
    private String timeStr;
    //文章统计
    private Integer count;

    private Long startTime;

    private Long endTime;

    @Override
    public int compareTo(ArchiveVO other) {
        return (other.getEndTime() - this.getEndTime() > 0L) ? 1 : -1;
    }
}