package com.jh.board.board.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jh.board.board.entity.BoardEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDetailDto {
    private Long boardId;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    


    public static BoardDetailDto toDto(BoardEntity boardEntity){
        return BoardDetailDto.builder()
                        .boardId(boardEntity.getId())
                        .boardWriter(boardEntity.getBoardWriter())
                        .boardPassword(boardEntity.getBoardPassword())
                        .boardTitle(boardEntity.getBoardTitle())
                        .boardContents(boardEntity.getBoardContents())
                        .build();
    }

    public static List<BoardDetailDto> toDtos(List<BoardEntity> boardEntities){
        List<BoardDetailDto> boardDetailDtos = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntities){
            boardDetailDtos.add(toDto(boardEntity));
        }

        return boardDetailDtos;
    }
}
