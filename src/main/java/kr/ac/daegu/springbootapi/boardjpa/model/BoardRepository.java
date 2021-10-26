package kr.ac.daegu.springbootapi.boardjpa.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends CrudRepository<Board, Integer> {
    List<Board> findAll();

    Board findBoardById(Integer id);
    Optional<Board> findBoardById(int id);

    List<Board> findBoardByIsDel(String isDel);
}
