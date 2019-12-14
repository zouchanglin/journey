package edu.xpu.journey.controller.admin;

import edu.xpu.journey.VO.ArticleInfoVO;
import edu.xpu.journey.convert.ArticleInfoConvert;
import edu.xpu.journey.entity.ArticleInfo;
import edu.xpu.journey.entity.TagInfo;
import edu.xpu.journey.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author x
 */
@Controller
@Slf4j
@RequestMapping("/admin/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleInfoConvert articleInfoConvert;

    /**
     * 查看标签列表
     * @param map 填充参数
     * @return 标签展示
     */
    @RequestMapping("/list")
    public String list(Map<String, Object> map){
        List<TagInfo> allTags = tagService.getAllTags();
        map.put("allTags", allTags);
        return "admin/tag/list";
    }

    @RequestMapping("/show/articles/{tag}")
    public String showArticles(@PathVariable("tag") Integer tag){
        List<ArticleInfo> allArticleForTag = tagService.getAllArticleForTag(tag);
        List<ArticleInfoVO> articleInfoVOList = articleInfoConvert.convertList(allArticleForTag);
        //TODO 跳转到前端页面展示吧
        return "";
    }


    /**
     * 创建新标签
     * @param tagName 标签名称
     * @param map 填充参数
     * @return success页面
     */
    @RequestMapping("/new")
    public String newTagInfo(@RequestParam("tagName") String tagName,
                             Map<String, Object> map){
        if(TextUtils.isEmpty(tagName)){
            map.put("msg", "请保持参数完整性 ");
            map.put("url", "/admin/tag/list");
            return "/admin/common/error";
        }
        tagService.addNewTag(tagName);
        map.put("url", "/admin/tag/list");
        map.put("msg", "添加成功");
        return "/admin/common/success";
    }

    /**
     * 更行标签
     * @param tagId 标签ID
     * @param tagName 标签名称
     * @param map 填充参数
     * @return success页面
     */
    @RequestMapping("/update")
    public String updateTagInfo(@RequestParam("tagId") Integer tagId,
                                @RequestParam("tagName") String tagName,
                                Map<String, Object> map){
        tagService.updateTag(tagId, tagName);
        map.put("url", "/admin/tag/list");
        map.put("msg", "修改成功");
        return "/admin/common/success";
    }

    /**
     * 删除标签
     * @param tagId 标签ID
     * @return 刷新页面
     */
    @RequestMapping("/delete/{tagId}")
    public String deleteTag(@PathVariable("tagId") Integer tagId){
        tagService.deleteTagById(tagId);
        return "redirect:/admin/tag/list";
    }
}