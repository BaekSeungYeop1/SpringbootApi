package kr.ac.daegu.springbootapi.board.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    List<BoardDTO> getBoardList();

    int insertBoard(BoardDTO boardDTO);

    int putBoard(BoardDTO boardDTO);

    BoardDTO getBoardById(int id);

    int updateIsDelBoardById(int id);

}
