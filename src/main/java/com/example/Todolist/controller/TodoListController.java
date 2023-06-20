package com.example.Todolist.controller;

import com.example.Todolist.entity.Todo;
import com.example.Todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor //2
public class TodoListController {
    private final TodoRepository todoRepository; //コンストラクタインジェクション

    @GetMapping("/todo")
    public ModelAndView showTodoList(ModelAndView mv) {
        //一覧を検索して表示する
        mv.setViewName("todoList");
        List<Todo> todoList = todoRepository.findAll(); //3 TodoRepositoryで自動生成されるメソッドを使用
        mv.addObject("todoList", todoList); //4
        return mv;
    }


}
