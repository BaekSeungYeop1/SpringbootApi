package kr.ac.daegu.springbootapi.comment.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.board.service.BoardService;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.comment.service.CommentService;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    /* mission Comment 기능 만들기 */
    // 1. 댓글 목록 불러오기
    // GET /comment/{boardId}

    public final CommentService commentService;

    @GetMapping(value = "/{id}")
    public ApiResponse<CommentDTO> getCommentList(@PathVariable int id) {
        List<CommentDTO> commentlist = commentService.getCommentList(id);
        return new ApiResponse(true, commentlist);
    }




    // 2. 글에 딸린 댓글 목록 불러오기
    // GET /board/{id} 를 고쳐서.
}
