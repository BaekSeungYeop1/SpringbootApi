package kr.ac.daegu.springbootapi.comment.service;


import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    public final CommentDAO commentDAO;

    public List<CommentDTO> getCommentList(int id) {
        return commentDAO.getCommentList(id);
    }
}
