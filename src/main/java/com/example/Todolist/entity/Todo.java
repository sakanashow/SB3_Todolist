package com.example.Todolist.entity;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity //1 このクラスがエンティティであることを示す
@Table(name="todo") //2　対応しているテーブルを指定する。これによりTodoオブジェクトへの操作は自動的にtodoテーブルのレコードに対する操作になる
@Data
public class Todo {
    @Id //3 主キーであるおことを表す
    @GeneratedValue(strategy = GenerationType.IDENTITY) //4　主キーが自動採番されることを表す
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name = "importance")
    private String importance;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "done")
    private String done;
}
