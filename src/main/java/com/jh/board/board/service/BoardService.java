package com.jh.board.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jh.board.board.dto.BoardDetailDto;
import com.jh.board.board.dto.BoardSaveDto;
import com.jh.board.board.dto.BoardUpdateDto;


@Service
public interface BoardService {

    
    public Long save(BoardSaveDto boardSaveDto);

    public List<BoardDetailDto> findAll();

    public BoardDetailDto findById(Long boardId);

    public Long update(BoardUpdateDto boardUpdateDto);

    public void deleteById(Long boardId);
}
