package kr.ac.daegu.springbootapi.board.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {
    public final BoardDAO boardDAO;

    public List<BoardDTO> getBoardList() { return boardDAO.getBoardList();}

    public BoardDTO insertBoard(BoardDTO boardDTO) throws Exception {
        log.debug(boardDTO.toString());

        // Inserted Date, Inserted Time 정의
        boardDTO.setWriteDate(LocalDate.now());
        boardDTO.setWriteTime(LocalTime.now());

        int insertedRowCount = boardDAO.insertBoard(boardDTO);
        if(insertedRowCount > 0){

            return boardDTO;
        } else {
            throw new Exception("failed to insert board data");
        }
    }

    public String putBoard(int id, BoardDTO boardDTO) throws Exception{
        // author,
        // content,
        // subject,
        // content
        // writeDate, writeTime 업데이트
        boardDTO.setId(id);
        boardDTO.setWriteDate(LocalDate.now());
        boardDTO.setWriteTime(LocalTime.now());
        int result = boardDAO.putBoard(boardDTO);

        if(result > 0){
            return result + " rows updated";
        }
        throw new Exception("failed to update " + id + " content");
    }


    public String deleteBoard(int id) throws Exception{
        int result = boardDAO.deleteBoard(id);

        if (result > 0){
            return result + " rows deleted";
        }
        throw new Exception("failed to delete " + id + " content");

    }

    public ApiResponse<BoardDTO> getBoardById(int id) {
        BoardDTO data = boardDAO.getBoardById(id);
        return new ApiResponse(true, data);
    }
}
