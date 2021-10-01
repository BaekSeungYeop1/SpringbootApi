package kr.ac.daegu.springbootapi.comment.model;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO {


    List<CommentDTO> getCommentList(int id);

}
