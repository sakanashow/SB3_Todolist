package com.example.Todolist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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
    private Integer importance;

    @Column(name = "urgency")
    private Integer urgency;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "done")
    private String done;

}
