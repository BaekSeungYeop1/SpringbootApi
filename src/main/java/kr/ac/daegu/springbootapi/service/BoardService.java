package kr.ac.daegu.springbootapi.service;

import kr.ac.daegu.springbootapi.model.TestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    public List<TestDTO> getTestList() {
        List<TestDTO> testList = new ArrayList<TestDTO>();
        testList.add(new TestDTO(1, "name1"));
        testList.add(new TestDTO(2, "name2"));
        testList.add(new TestDTO(3, "name3name3"));
        return testList;
    }

}
