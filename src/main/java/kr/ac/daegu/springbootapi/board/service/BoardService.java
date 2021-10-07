package kr.ac.daegu.springbootapi.board.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
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
    public final CommentDAO commentDAO;

    //6 글 전체 보기 수정
    //GET /board/
    //isDel = ‘Y’ 인 아이들만 보이도록
    public List<BoardDTO> getBoardList() {
        return boardDAO.getBoardList();
    }

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

    /*
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
     */

    public ApiResponse<BoardDTO> putBoard(int id, BoardDTO boardDTO) {
        BoardDTO selectedData = boardDAO.getBoardById(id);
        String userInputPassword = boardDTO.getPassword();

        if (userInputPassword.equals(selectedData.getPassword())) {
            // author,
            // content,
            // subject,
            // content
            // writeDate, writeTime 업데이트
            boardDTO.setId(id);
            boardDTO.setWriteDate(LocalDate.now());
            boardDTO.setWriteTime(LocalTime.now());
            int result = boardDAO.putBoard(boardDTO);

            if (result > 0) {
                return new ApiResponse(true, "success to update board id " + id);
            }
        }
        return new ApiResponse(false,"password incorrect in board id " + id);
    }

    public ApiResponse<BoardDTO> getBoardById(int id) {
        BoardDTO data = boardDAO.getBoardById(id);
        List<CommentDTO> commentsById = commentDAO.getCommentsById(id);
        data.setComments(commentsById);

        String deletedData = data.getIsDel();
        log.debug("deletedData = " + deletedData);
        if (deletedData.equals("Y")){
            return new ApiResponse(false, "board id " + id + " is already deleted.");
        }
        return new ApiResponse(true, data);
    }

    // 내가 만든 delete 기능
    /*
    public String deleteBoard(int id) throws Exception{
        int result = boardDAO.deleteBoard(id);

        if (result > 0){
            return result + " rows deleted";
        }
        throw new Exception("failed to delete " + id + " content");

    }
     */


    // Board테이블의 isDel 컬럼의 데이터를 'Y' 로 업데이트
    public ApiResponse<BoardDTO> updateIsDelBoardById(int id, BoardDTO boardDTO) {
        BoardDTO selectedData = boardDAO.getBoardById(id);
        String userInputPassword = boardDTO.getPassword();

        if (userInputPassword.equals(selectedData.getPassword())) {
            int updatedRow = boardDAO.updateIsDelBoardById(id);

            if (updatedRow > 0) {
                return new ApiResponse(true, "success to delete board id " + id);
            }
        }
        return new ApiResponse(false, "password incorrect in board id " + id);
    }


}
