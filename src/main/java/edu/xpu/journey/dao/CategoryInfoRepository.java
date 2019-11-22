package edu.xpu.journey.dao;

import edu.xpu.journey.entity.CategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Integer> {

}