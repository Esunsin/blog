package com.sparta.blog.entity;

import com.sparta.blog.dto.BoardRequestDto;
import com.sparta.blog.service.BoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    @Test
    @DisplayName("생성")
    void Board(){
        //given
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setTitle("title");
        boardRequestDto.setContent("content");
        User user = new User();
        //when
        Board board = new Board(boardRequestDto, user);
        //then
        assertEquals(boardRequestDto.getTitle(),board.getTitle());
        assertEquals(boardRequestDto.getContent(),board.getContent());
    }
    @Test
    @DisplayName("수정")
    void updateMethod(){
        //given
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setTitle("title");
        boardRequestDto.setContent("content");
        User user = new User();
        Board board = new Board(boardRequestDto, user);
        BoardRequestDto updateBoard = new BoardRequestDto();
        updateBoard.setTitle("update title");
        updateBoard.setContent("update content");
        //when
        board.update(updateBoard);
        //then
        assertEquals(updateBoard.getTitle(), board.getTitle());
        assertEquals(updateBoard.getContent(),board.getContent());
    }
}
