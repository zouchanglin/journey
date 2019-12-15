package edu.xpu.journey.service;

import edu.xpu.journey.vo.ArchiveVO;

import java.util.List;

/**
 * 文章归档服务
 * @author x
 */
public interface ArchiveService {
    List<ArchiveVO> getArchiveData();
}