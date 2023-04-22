package com.jh.board.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BoardSaveDto {
    
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;

}
