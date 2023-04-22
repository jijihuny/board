package com.jh.board.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jh.board.board.dto.BoardDetailDto;
import com.jh.board.board.dto.BoardSaveDto;
import com.jh.board.board.dto.BoardUpdateDto;
import com.jh.board.board.entity.BoardEntity;
import com.jh.board.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardRepository boardRepository;

    @Override
    public Long save(BoardSaveDto boardSaveDto){
        return boardRepository.save(BoardEntity.toEntity(boardSaveDto)).getId();
    }

    @Override
    public List<BoardDetailDto> findAll(){
        return BoardDetailDto.toDtos(boardRepository.findAll());
    }

    @Override
    public BoardDetailDto findById(Long boardId){
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(boardId);
        
        return optionalBoardEntity.isPresent() ?
                BoardDetailDto.toDto(optionalBoardEntity.get()) :
                null;
    }

    @Override
    public Long update(BoardUpdateDto boardUpdateDto){
        
        return boardRepository.save(BoardEntity.toEntity(boardUpdateDto)).getId();
    }

    @Override
    public void deleteById(Long boardId){
        boardRepository.deleteById(boardId);
    }
}

