package com.jh.board.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.board.board.dto.BoardDetailDto;
import com.jh.board.board.dto.BoardSaveDto;
import com.jh.board.board.dto.BoardUpdateDto;
import com.jh.board.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService boardService;


    @GetMapping("/")
    public String findAll(Model model){
        // log.info("Board id : {}", model.getAttribute(null));

        List<BoardDetailDto> boardDetailDtos = boardService.findAll();
        
        model.addAttribute("boardList", boardDetailDtos);
        return "board/findAll";
    }

    @GetMapping("/{boardId}")
    public String findById(@PathVariable Long boardId, Model model){
        log.info("The board id : {}", boardId);

        BoardDetailDto boardDetailDto = boardService.findById(boardId);

        model.addAttribute("boardDetailDto", boardDetailDto);

        return "board/findById";
    }

    @GetMapping("/save")
    public String saveForm(Model model){
        model.addAttribute("board", new BoardSaveDto());

        return "board/save";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("board") BoardSaveDto boardSaveDto){
        boardService.save(boardSaveDto);
        
        return "index";
    }

    @GetMapping("/update/{boardId}")
    public String updateForm(@PathVariable Long boardId, Model model){
        BoardDetailDto boardDetailDto = boardService.findById(boardId);
        model.addAttribute("boardDetailDto", boardDetailDto);

        return "board/update";
    }

    @PutMapping("/{boardId}")
    public ResponseEntity update(@RequestBody BoardUpdateDto boardUpdateDto){
        boardService.update(boardUpdateDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
