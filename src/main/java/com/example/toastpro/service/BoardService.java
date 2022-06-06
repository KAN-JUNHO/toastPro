package com.example.toastpro.service;

import com.example.toastpro.dto.BoardAttachVO;
import com.example.toastpro.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public void register(BoardDTO board);
    public List<BoardDTO> selectList(BoardDTO boardDTO);
    public BoardDTO select(Long board_idx);
    public List<BoardDTO> gets(Long employee_idx);
    public boolean modify(BoardDTO vo);

    public int removeFile(String uuid);
    public boolean remove(Long board_idx);
    public List<BoardDTO> getList();
    public List<BoardAttachVO> getAttachList(Long boardIdx);
}
