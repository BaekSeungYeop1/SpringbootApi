package kr.ac.daegu.springbootapi.board.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    public final BoardDAO boardDAO;

    public List<BoardDTO> getBoardList() { return boardDAO.getBoardList();}
}
