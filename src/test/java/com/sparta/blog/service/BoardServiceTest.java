package com.sparta.blog.service;

import com.sparta.blog.dto.BoardRequestDto;
import com.sparta.blog.dto.BoardResponseDto;
import com.sparta.blog.entity.Board;
import com.sparta.blog.entity.User;
import com.sparta.blog.repository.BoardRepository;
import com.sparta.blog.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // @Mock 사용을 위해 설정합니다.
public class BoardServiceTest {

    @Mock
    BoardRepository boardRepository;
    @Mock
    CommentRepository commentRepository;

    @Test
    @DisplayName("게시물 생성")
    void createBoard(){
        //given
        Long boardId = 100L;
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setTitle("title");
        boardRequestDto.setContent("content");
        User user = new User();
        BoardService boardService = new BoardService(boardRepository, commentRepository);
        Board expectedBoard = new Board(boardRequestDto, user);

        when(boardRepository.save(any(Board.class))).thenReturn(expectedBoard);
        //when
        BoardResponseDto boardResponseDto = boardService.createBoard(user, boardRequestDto);
        //then
        assertEquals(boardRequestDto.getTitle(),boardResponseDto.getTitle());

    }

}
