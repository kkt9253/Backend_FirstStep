package ch9;

import java.util.ArrayList;

public class _Q_09 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("유재석", "파이썬")); // 객체를 생성 후 그 안에 이름과 언어를 넣음
        list.add(new Student("박명수", "자바"));
        list.add(new Student("김종국", "자바"));
        list.add(new Student("조세호", "C"));
        list.add(new Student("서장훈", "파이썬"));

        System.out.println("자바 자격증을 보유한 학생");
        System.out.println("------------------------");

        for (Student student : list) {
            if (student.lang.equals("자바")) {
                System.out.println(student.name);
            }
        }

    }
}

class Student {
    public String name;
    public String lang;

    public Student(String name, String lang) {
        this.name = name;
        this.lang = lang;
    }
}