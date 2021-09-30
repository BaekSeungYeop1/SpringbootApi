package kr.ac.daegu.springbootapi.board.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    List<BoardDTO> getBoardList();

    int insertBoard(BoardDTO boardDTO);

    int putBoard(BoardDTO boardDTO);

    int deleteBoard(int id);
}
