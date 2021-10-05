package kr.ac.daegu.springbootapi.comment.service;


import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    public final CommentDAO commentDAO;

    public List<CommentDTO> getCommentList(int id) {
        return commentDAO.getCommentList(id);
    }

    public CommentDTO insertComment(CommentDTO commentDTO) throws Exception {
        commentDTO.setWriteDate(LocalDate.now());
        commentDTO.setWriteTime(LocalTime.now());

        int insertRowCount = commentDAO.insertComment(commentDTO);
        if (insertRowCount > 0){
            return commentDTO;
        }else {
            throw new Exception("failed to insert comment data");
        }
    }

}
