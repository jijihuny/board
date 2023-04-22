package com.jh.board.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jh.board.board.dto.BoardSaveDto;
import com.jh.board.board.dto.BoardUpdateDto;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "board_table")
@Builder
public class BoardEntity extends BaseEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;


    @Column
    private String boardWriter;

    @Column
    private String boardPassword;

    @Column
    private String boardTitle;

    @Column
    private String boardContents;



    public static BoardEntity toEntity(BoardSaveDto boardSaveDto){
        return BoardEntity.builder()
                    .boardWriter(boardSaveDto.getBoardWriter())
                    .boardPassword(boardSaveDto.getBoardPassword())
                    .boardTitle(boardSaveDto.getBoardTitle())
                    .boardContents(boardSaveDto.getBoardContents())
                    .build();
    }

    public static BoardEntity toEntity(BoardUpdateDto boardUpdateDto){
        return BoardEntity.builder()
                .id(boardUpdateDto.getBoardId())
                .boardWriter(boardUpdateDto.getBoardWriter())
                .boardPassword(boardUpdateDto.getBoardPassword())
                .boardTitle(boardUpdateDto.getBoardTitle())
                .boardContents(boardUpdateDto.getBoardContents())
                .build();
    }
}
