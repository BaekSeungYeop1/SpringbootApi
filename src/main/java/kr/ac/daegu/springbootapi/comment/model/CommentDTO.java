package kr.ac.daegu.springbootapi.comment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private int cid;            // 댓글  id
    private int id;             // 게시글 id
    private String author;      // 작성자
    private String content;     // 글 컨텐츠
    private LocalDate writeDate;     // 작성날짜
    private LocalTime writeTime;     // 작성 시간
}
