package edu.xpu.journey.service.impl.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.mapper.ArticleInfoMapper;
import edu.xpu.journey.enums.ArticleStatusEnum;
import edu.xpu.journey.service.ArchiveService;
import edu.xpu.journey.vo.ArchiveVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author x
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArchiveVO> getArchiveData() {
        List<ArchiveVO> resultVO = Lists.newArrayList();
        //先找到创建时间最早的文章
        List<ArticleInfo> ret = articleInfoMapper.findAllByStatusOrderByCreatTime(ArticleStatusEnum.RELEASE.getCode());
        if(ret.size() > 0){
            Set<ArchiveVO> deal = Sets.newHashSet();
            for(ArticleInfo articleInfo: ret){
                ArchiveVO archiveVO = new ArchiveVO();
                archiveVO.setCount(0);
                archiveVO.setArticleList(Lists.newArrayList());
                archiveVO.setStartTime(getThisMonth(articleInfo.getCreatime()));
                archiveVO.setEndTime(getLastMonth(articleInfo.getCreatime()));
                archiveVO.setTimeStr(new SimpleDateFormat("yyyy年MM月").format(new Date(articleInfo.getCreatime())));
                deal.add(archiveVO);
            }

            for(ArchiveVO archiveVO:  deal){
                for(ArticleInfo articleInfo: ret){
                    Long creatime = articleInfo.getCreatime();
                    if(creatime > archiveVO.getStartTime() && creatime <= archiveVO.getEndTime()){
                        List<ArticleInfo> articleList = archiveVO.getArticleList();
                        articleList.add(articleInfo);
                        archiveVO.setArticleList(articleList);
                        archiveVO.setCount(archiveVO.getCount()+1);
                    }
                }
                resultVO.add(archiveVO);
            }
        }
        Collections.sort(resultVO);
        return resultVO;
    }

    //获得月初的时间戳
    private static long getThisMonth(long time){
        String startData = new SimpleDateFormat("yyyy-MM").format(new Date(time));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-01");
        try {
            Date date = simpleDateFormat.parse(startData+"-01 00:00");
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }
    //获得月末的时间戳
    private static long getLastMonth(long time){
        long thisMonth = getThisMonth(time);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(time));
        String[] split = format.split("-");
        long addTime = 0L;
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        if(month == 2){
            if((year%4) == 0 && (year%100) != 0){
                //闰年
                addTime = 29 * 24 * 3600 * 1000L;
            }else{
                //非闰年
                addTime = 28 * 24 * 3600 * 1000L;
            }
        }else{
            if(month==1 || month==3 || month==5 || month == 7 || month == 8 || month == 10 || month == 12){
                addTime = 31 * 24 * 3600 * 1000L;
            }else{
                addTime = 30 * 24 * 3600 * 1000L;
            }
        }
        return thisMonth + addTime - 1;
    }

    public static void main(String[] args) {
        long now = 1576405908155L;
        //当前时间戳
        System.out.println("当前时间 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(now)));
        //拿到1576405656434L 的这个月的第一天的00:00 的时间戳
        long thisMonth = getThisMonth(now);
        System.out.println("月初时间 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(thisMonth)));
        //拿到1576405656434L 的这个月的最后一天的00:00 的时间戳
        long lastMonth = getLastMonth(now);
        System.out.println("月末时间 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(lastMonth)));
    }
}
