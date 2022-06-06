package com.example.toastpro.service;

import com.example.toastpro.dao.BoardAttachDAO;
import com.example.toastpro.dao.BoardDAO;
import com.example.toastpro.dto.BoardAttachVO;
import com.example.toastpro.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardDAO mapper;
    private BoardAttachDAO attachMapper;


    @Override
    public void register(BoardDTO board) {
        log.info("register...." + board.getBoardIdx());
        mapper.insertSelectKey(board);
        log.info("register....222" + board);
        if(board.getAttachList() == null || board.getAttachList().size()<=0) {
            return;
        }
        board.getAttachList().forEach(attach->{
            log.info("active ~ file upload");
            attach.setBoardIdx(board.getBoardIdx());
            attachMapper.insert(attach);
        });
    }

    @Override
    public List<BoardDTO> gets(Long employee_idx) {
        log.info("get...." + employee_idx);
        return mapper.reads(employee_idx);
    }
    @Override
    public BoardDTO select(Long board_idx) {
        // TODO Auto-generated method stub
        return mapper.select(board_idx);
    }



    @Override
    public boolean modify(BoardDTO board) {
        log.info("modify...." + board);


        if(board.getAttachList() == null || board.getAttachList().size()<=0) {
            return 1==mapper.update(board);
        }
        board.getAttachList().forEach(attach->{
            log.info("active ~ file upload");
            attach.setBoardIdx(board.getBoardIdx());
            attachMapper.insert(attach);
        });
        return 1==mapper.update(board);
    }
    @Override
    public int removeFile(String uuid) {
        // TODO Auto-generated method stub
        return attachMapper.delete(uuid);
    }

    @Override
    public boolean remove(Long boardIdx) {
        log.info("remove...." + boardIdx);
        attachMapper.deleteAll(boardIdx);
        return mapper.delete(boardIdx) == 1;
    }

    @Override
    public List<BoardDTO> getList() {
        log.info("getList....");
        return mapper.getBoardList();
    }

    @Override
    public List<BoardDTO> selectList(BoardDTO boardDTO) {
        // TODO Auto-generated method stub
        return mapper.getBoardList();
    }

    @Override
    public List<BoardAttachVO> getAttachList(Long boardIdx) {
        // TODO Auto-generated method stub
        return attachMapper.findByboardIdx(boardIdx);
    }


}

