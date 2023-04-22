package com.jh.board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPagingDto {
    private Long boardId;
    private String boardWriter;
    private String boardTitle;
}
