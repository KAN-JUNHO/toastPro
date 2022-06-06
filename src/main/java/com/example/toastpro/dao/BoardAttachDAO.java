package com.example.toastpro.dao;


import com.example.toastpro.dto.BoardAttachVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardAttachDAO {
	public void insert(BoardAttachVO vo);
	public int delete(String uuid);
	public List<BoardAttachVO> findByboardIdx(Long boardIdx);
	public int deleteAll(Long boardIdx);
	public List<BoardAttachVO> getOldFiles();
}
