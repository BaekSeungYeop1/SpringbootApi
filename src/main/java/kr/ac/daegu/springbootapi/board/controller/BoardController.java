package kr.ac.daegu.springbootapi.board.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    /* mission */
    // postman에서 GET http://localhost:8080/board/ 요청 날려서
    // DB의 board 테이블 데이터 모두 가져와서 json return 해보기.

    public final BoardService boardService;

    @GetMapping(value = "/")
    public List<BoardDTO> rootTest() throws Exception {
        log.trace("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // 로그의 5단계 trace(일반적으로 남기는 이벤트 기록) -> debug(디버깅용) -> info(알림) -> warn(경고) -> error(에러)
        log.debug("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.warn("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.error("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 간단한 list 생성
        List<BoardDTO> boardList = boardService.getBoardList();

        return boardList;
    }
}
