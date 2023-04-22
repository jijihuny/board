package com.jh.board.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.board.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    
}
