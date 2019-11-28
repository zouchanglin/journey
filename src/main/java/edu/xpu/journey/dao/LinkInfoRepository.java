package edu.xpu.journey.dao;

import edu.xpu.journey.entity.LinkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkInfoRepository extends JpaRepository<LinkInfo, Integer> {
}