package com.example.Todolist.controller;

import com.example.Todolist.entity.Todo;
import com.example.Todolist.form.TodoData;
import com.example.Todolist.repository.TodoRepository;
import com.example.Todolist.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor //2
public class TodoListController {
    private final TodoRepository todoRepository; //コンストラクタインジェクション
    private final TodoService todoService; //Todo2で追加(コンストラクタインジェクション)

    //todo1
    @GetMapping("/todo")
    public ModelAndView showTodoList(ModelAndView mv) {
        //一覧を検索して表示する
        mv.setViewName("todoList");
        List<Todo> todoList = todoRepository.findAll(); //3 TodoRepositoryで自動生成されるメソッドを使用
        mv.addObject("todoList", todoList); //4
        return mv;
    }

    //Todo入力フォーム表示 Todo2で追加
    // 「処理１」Todo一覧画面(todoList.html)で[新規追加]リンクがクリックされたとき
    @GetMapping("/todo/create") //オーバーロード
    public ModelAndView createTodo(ModelAndView mv) {
        mv.setViewName("todoForm"); // 1 呼び出されると入力画面が表示される
        mv.addObject("todoData", new TodoData()); //2　入力画面は初期化された状態で始まる
        return mv;
    }

    //Todo2で追加
    // 「処理２」Todo一覧画面(todoList.html)で[登録]ボタンがクリックされたとき
    @PostMapping("/todo/create") //オーバーロード
    public ModelAndView createTodo(@ModelAttribute @Validated TodoData todoData,//３ Validatedによって画面入力のバリデーションチェックを行う。結果はBindingResultオブジェクトに格納// 　
                                   BindingResult result, ModelAndView mv) {
        //エラーチェック
        boolean isValid = todoService.isValid(todoData, result); //４
        if(!result.hasErrors() && isValid) {
            //エラーなし
            Todo todo = todoData.toEntity(); //5 エラーがなければToDoテーブルに追加する
            todoRepository.saveAndFlush(todo);//insert文に相当する処理を自動実行してくれる
            return showTodoList(mv);
        } else {
            //エラーあり
            mv.setViewName("todoForm"); //6
            mv.addObject("todoData", todoData); //この文は省略可能
            return mv;
        }
    }

    //Todo一覧へ戻る Todo２で追加
    // 「処理3」Todo入力画面で[キャンセル登録]ボタンがクリックされたとき
    @PostMapping("/todo/cancel")
    public String cancel() {
        return "redirect:/todo";
    }
}
