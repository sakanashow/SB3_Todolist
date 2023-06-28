package com.example.Todolist.repository;

import com.example.Todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository //リポジトリであることを示す
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    // インターフェースの継承元　todoが対象エンティティ、＠idが指定されているクラス
    List<Todo> findByTitleLike(String title);
    List<Todo> findByImportance(Integer importance);
    List<Todo> findByUrgency(Integer urgency);
    List<Todo> findByDeadlineBetweenOrderByDeadlineAsc(Date from, Date to);
    List<Todo> findByDeadlineGreaterThanEqualOrderByDeadlineAsc(Date from);
    List<Todo> findByDeadlineLessThanEqualOrderByDeadlineAsc(Date to);
    List<Todo> findByDone(String done);
}
