package kr.ac.daegu.springbootapi.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDAO {
    List<TestDTO> getTestList();
}
