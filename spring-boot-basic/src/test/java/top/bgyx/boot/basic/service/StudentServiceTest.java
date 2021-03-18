package top.bgyx.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bgyx.boot.basic.entity.Student;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentServiceTest {
    @Resource
    private  StudentService studentService;

    @Test
    void postStudent() {
        Student student = Student.builder()
//                .name("linfan")
                .github_name("ligoufan")
                .nickname("Hyy")
                .hometown("江苏xuzhou")
                .birthday("2001-10-23")
                .constellation("天cheng座")
                .mobile("13218572781 ")
                .qq("1400695792")
                .email("1400695792@qq.com")
                .avatar("https://wshan.oss-cn-beijing.aliyuncs.com/head.jpg")
                .github("https://github.com/Ws1118")
                .hobby("lanqiu")
                .signature("shizi")
                .color("#F6F000")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(0)
                .build();
        log.info("student:" + student);
        boolean flag = studentService.postStudent(student);
        log.info("flag"+flag);
        assertTrue(flag);

    }

    @Test
    void getStudentList() {

    }

    @Test
    void getStudentById() {
//        List<Student> StudentList = studentService.findById(9);
//        System.out.println(StudentList);
    }

    @Test
    void deleteStudentById() {

    }

    @Test
    void updateStudent() {
    }

    @Test
    void testGetStudentList() {
    }

    @Test
    void testPostStudent() {
    }
}