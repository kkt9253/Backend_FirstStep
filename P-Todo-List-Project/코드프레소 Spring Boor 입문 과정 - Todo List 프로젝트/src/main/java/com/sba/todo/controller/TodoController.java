package com.sba.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import com.sba.todo.service.TodoService;
import com.sba.todo.vo.Result;
import com.sba.todo.vo.Todo;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //@GetMapping("/todo")
    @GetMapping
    @ResponseBody
    public List<Todo> getTodoList(){
        List<Todo> list = todoService.getTodoList();
        return list;
    }

    //@PostMapping("/todo")
    @PostMapping
    @ResponseBody
    public Object addTodo(HttpServletResponse response, @RequestBody Todo todoParam) {
        //HttpServletResponse response: HTTP 응답 객체로, 응답을 조작할 수 있는 기능을 제공합니다.
        Todo todo = new Todo(todoParam.getContent()); //todoParam에서 getContent 메서드를 이용하여 값을 가져옴
        todoService.addTodo(todo);

        response.setStatus(HttpServletResponse.SC_OK); //HTTP에서 성공적인 요청에 대한 응답을 나타내는 상태 코드, 200을 나타냄
        // return new Result(HttpServletResponse.SC_OK, "Success");
        return new Result(200, "Success"); // 둘 중 하나만 사용하면 됨.
    }

    @DeleteMapping(value = "/{id}")
    //@DeleteMapping("/todo/{id}")
    public Object deleteTodo(HttpServletResponse response, @PathVariable("id") String id) {
        todoService.deleteTodo(Integer.parseInt(id));

        response.setStatus(HttpServletResponse.SC_OK);
        return new Result(200, "Success");
    }

}
