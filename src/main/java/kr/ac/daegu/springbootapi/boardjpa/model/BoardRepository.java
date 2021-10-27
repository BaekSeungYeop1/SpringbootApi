package kr.ac.daegu.springbootapi.boardjpa.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAll();

    Board findBoardById(Integer id);
    Optional<Board> findBoardById(int id);

    Page<Board> findBoardsByIsDel(String isDel, Pageable pageable);
}
