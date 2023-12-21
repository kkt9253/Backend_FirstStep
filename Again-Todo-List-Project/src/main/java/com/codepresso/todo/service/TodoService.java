package com.codepresso.todo.service;

import java.util.List;

import com.codepresso.todo.vo.Todo;
import org.springframework.stereotype.Service;

@Service //의존성
public class TodoService {

    //todo 멤버 변수 todoList에 의존성 주입
    private List<Todo> todoList;
    public TodoService(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public List<Todo> getTodoList(){
        //todo todoList 정보들을 반환
        return todoList;
    }

    public void addTodo(Todo todo) {
        //todo todoList에 새로운 항목을 추가
        todo.setId(todoList.size());
        todoList.add(todo);
    }

    public void deleteTodo(int index) {
        //todo todoList에서 index에 해당하는 항목을 삭제
        todoList.remove(index);
    }
}
