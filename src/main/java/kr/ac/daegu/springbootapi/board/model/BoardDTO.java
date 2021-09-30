package kr.ac.daegu.springbootapi.board.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class BoardDTO {
    private int id;                      // 글 id(글번호)
    private String author;               // 작성자 이름
    private String subject;              // 글 제목
    private String content;              // 글 컨텐츠
    private LocalDate writeDate;              // 작성 날짜
    private LocalTime writeTime;              // 작성 시간
    private int readCount;               // 조회수
    private int commentCount;            // 댓글 갯수
    private String password;             // 수정 삭제를 위한 패스워드

    private int replyRootId;                   // 원래 글 번호 (답글일 경우)
    private int depth;                   // (답글일경우) 제목의 'RE: ' 갯수
    private int orderNum;                // (답글일경우) 글 목록보기 순서



    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", writeDate=" + writeDate +
                ", writeTime=" + writeTime +
                ", readCount=" + readCount +
                ", commentCount=" + commentCount +
                ", password='" + password + '\'' +
                ", replyRootId=" + replyRootId +
                ", depth=" + depth +
                ", orderNum=" + orderNum +
                '}';
    }
}