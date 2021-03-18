package top.bgyx.boot.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.bgyx.boot.basic.controller.dto.AjaxResponse;
import top.bgyx.boot.basic.entity.Student;
import top.bgyx.boot.basic.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lingoufan
 * @date 2021/3/16
 * @description StudentController
 **/

@RestController
@RequestMapping(value = "api/student")
@Slf4j
@Api(tags = "学生管理")
@Validated
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("body")
    @ApiOperation("增加学生信息")
    public AjaxResponse saveStudent(@RequestBody Student student) {
        boolean flag = studentService.postStudent(student);
        return AjaxResponse.success(student);
    }
    /**
     * 查询所有文章
     */
    @ApiOperation(value = "查询所有学生", notes = "查询所有学生")
    @GetMapping("all")
    public AjaxResponse selectStudents() {
        List<Student> StudentList = studentService.getStudentList();
        return AjaxResponse.success(StudentList);
    }

    @GetMapping
    @ApiOperation("通过id获取学生信息")
    public AjaxResponse getById(
            @ApiParam("id")
            @RequestParam int id) {
        return AjaxResponse.success(studentService.getStudentById(id), "查询成功");
    }

    @PutMapping()
    @ApiOperation("修改学生信息")
    public AjaxResponse updateStudent(@RequestBody Student student){
        return AjaxResponse.success(studentService.updateStudent(student),"ok");
    }


    @DeleteMapping()
    @ApiOperation("删除学生信息")
    public AjaxResponse deleteById(
            @RequestParam int id) {
        return AjaxResponse.success(studentService.deleteStudent(id), "删除成功");
    }

}