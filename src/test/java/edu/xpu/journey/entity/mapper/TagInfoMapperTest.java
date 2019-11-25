package edu.xpu.journey.entity.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.xpu.journey.entity.TagInfo;
import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TagInfoMapperTest {
	@Autowired
	private TagInfoMapper mapper;

	@Test
	public void findArticleTag(){
		Integer articleTag = mapper.findArticleTag(1, 8);
		if(articleTag == null){
			System.out.println("A");
		}else{
			System.out.println("B");
		}
	}
	@Test
	public void getAllTagsExcludeArticle(){
		List<TagInfo> excludeArticle = mapper.getAllTagsExcludeArticle(1);
		assertEquals(4, excludeArticle.size());
	}
	@Test
	public void findArticleTags(){
		List<TagInfo> articleTags = mapper.findArticleTags(8);
		assertEquals(0, articleTags.size());
	}

	@Test
	public void insertByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "AAA");
		map.put("amount", 0);
		int insertByMap = mapper.insertByMap(map);
		assertEquals(insertByMap, 1);
	}
	
	
	@Test
	public void insertByObject() {
		TagInfo tagInfo = new TagInfo();
		tagInfo.setName("BBB");
		tagInfo.setAmount(1);
		
		int insertByMap = mapper.insertByObject(tagInfo);
		assertEquals(insertByMap, 1);
	}

	@Test
	public void updateTagInfo(){
		int updateResult = mapper.updateTagInfo("DDD",2, 4);
		assertEquals(1, updateResult);
	}

	@Test
	public void updateTagInfoByObject(){
		TagInfo tagInfo = new TagInfo();
		tagInfo.setId(4);
		tagInfo.setName("EEE");
		tagInfo.setAmount(5);
		int updateResult = mapper.updateTagInfoByObject(tagInfo);
		assertEquals(1, updateResult);
	}

	@Test
	public void deleteTagInfo(){
		int updateResult = mapper.deleteTagInfo(4);
		assertEquals(1, updateResult);
	}
}