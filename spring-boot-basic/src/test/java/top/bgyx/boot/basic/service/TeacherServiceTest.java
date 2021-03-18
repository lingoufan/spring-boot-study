package top.bgyx.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bgyx.boot.basic.entity.Teacher;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class TeacherServiceTest {
    @Resource
    private  TeacherService teacherService;

    @Test
    void add() {
        Teacher teacher = Teacher.builder()
                .id(2)
                .age(18)
                .name("lllll")
                .build();
        boolean flag = teacherService.add(teacher);
        assertTrue(flag);
    }


    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findTeacherById() {
    }

    @Test
    void findTeacher() {
    }
}