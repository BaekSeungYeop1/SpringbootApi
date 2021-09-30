package kr.ac.daegu.springbootapi.board.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {
    public final BoardDAO boardDAO;

    public List<BoardDTO> getBoardList() { return boardDAO.getBoardList();}

    public BoardDTO insertBoard(BoardDTO boardDTO) throws Exception {
        log.debug(boardDTO.toString());
        int insertedRowCount = boardDAO.insertBoard(boardDTO);
        if(insertedRowCount > 0){

            return boardDTO;
        } else {
            throw new Exception("failed to insert board data");
        }
    }
}
