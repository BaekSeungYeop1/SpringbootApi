package kr.ac.daegu.springbootapi.controller;

import kr.ac.daegu.springbootapi.model.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BoardController {

    @RequestMapping(value = "/")
    public List<TestDTO> rootTest() throws Exception {
        log.trace("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // 로그의 5단계 trace(일반적으로 남기는 이벤트 기록) -> debug(디버깅용) -> info(알림) -> warn(경고) -> error(에러)
        log.debug("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.warn("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.error("logTest~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 간단한 list 생성
        List<TestDTO> testList = new ArrayList<TestDTO>();
        testList.add(new TestDTO(1, "name1"));
        testList.add(new TestDTO(2, "name2"));
        testList.add(new TestDTO(3, "name3name3"));

        return testList;
    }
}
