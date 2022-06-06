package com.example.toastpro.dao;

import com.example.toastpro.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface BoardDAO {
//	@Select("select * from tbl_board")
	public List<BoardDTO> getBoardList();
	
	public int insert(BoardDTO board);

	public int insertSelectKey(BoardDTO board);
	
	public List<BoardDTO> reads(Long employee_idx);

	public int update(BoardDTO boardDTO);

	public int delete(long boardIdx);
	
	public BoardDTO select(long boardIdx);
	
	
	public List<BoardDTO> selectemployee_idx(int employeeIdx);
	
	
	//file
	public void insertFile(Map<String, Object> map) throws Exception;

}
