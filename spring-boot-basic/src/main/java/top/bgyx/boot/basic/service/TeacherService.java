package top.bgyx.boot.basic.service;

import top.bgyx.boot.basic.entity.Teacher;

import java.util.List;

public interface TeacherService {

    boolean add(Teacher teacher);

    Teacher update(Teacher teacher);

    int delete(Integer id);

    Teacher findTeacherById(Integer id);

    List<Teacher> findTeacher();

}