package kr.ac.daegu.springbootapi.service;

import kr.ac.daegu.springbootapi.model.TestDAO;
import kr.ac.daegu.springbootapi.model.TestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    public final TestDAO testDAO;

    public List<TestDTO> getTestList() {
        return testDAO.getTestList();
    }

}
