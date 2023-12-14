package com.codepresso.todo.controller;

import java.util.List;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    //의존성 주입 코드 - TodoController는 TodoService를 사용하여 클라이언트의 요청에 대한 응답을 처리
    TodoService todoService;
    public TodoController(TodoService todoService) { //TodoService의 @Service로부터 의존성 주입
        this.todoService = todoService;
    }

    //todo API문서를 확인하여 GET /todo REST API를 완성
    @GetMapping
    public List<Todo> getTodoList(){
        List<Todo> list=todoService.getTodoList();
        return list;
    }

    //todo API문서를 확인하여 POST /todo REST API를 완성
    @PostMapping
    public ResultDto addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        //todo return code는 변경하지 마세요
        return new ResultDto(200, "Success");
    }

    //todo API문서를 확인하여 DELETE /todo REST API를 완성
    @DeleteMapping(value = "/{id}")
    public ResultDto deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodo(id); // 삭제 호출
        //todo return code는 변경하지 마세요
        return new ResultDto(200, "Success");
    }

}
