package com.example.Todolist.repository;

import com.example.Todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //リポジトリであることを示す
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    // インターフェースの継承元　todoが対象エンティティ、＠idが指定されているクラス
}
