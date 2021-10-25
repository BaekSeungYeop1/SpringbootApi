package kr.ac.daegu.springbootapi.boardjpa.service;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.boardjpa.model.Board;
import kr.ac.daegu.springbootapi.boardjpa.model.BoardRepository;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardJpaService {

    public final BoardRepository boardRepository;
    public final CommentDAO commentDAO;

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Integer id) {
        return boardRepository.findBoardById(id);
    }

    public Board postBoard(BoardDTO boardDTO) {
        Board postData = Board.builder()
                .author(boardDTO.getAuthor())
                .subject(boardDTO.getSubject())
                .content(boardDTO.getContent())
                .password(boardDTO.getPassword())
                .commentCount(0)
                .depth(0)
                .orderNum(0)
                .isDel("N")
                .readCount(0)
                .replyRootId(0)
                .writeDate(LocalDate.now())
                .writeTime(LocalTime.now())
                .build();


        return boardRepository.save(postData);
    }
}
