package top.bgyx.boot.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bgyx.boot.basic.controller.dto.AjaxResponse;
import top.bgyx.boot.basic.entity.Teacher;
import top.bgyx.boot.basic.service.TeacherService;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2021/3/18
 * @description TeacherController
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "add")
    public AjaxResponse addTeacher(Teacher teacher){
        boolean teacher1 = teacherService.add(teacher);
        return AjaxResponse.success(teacher1);
    }

    @RequestMapping(value = "list")
    public Object list(@RequestParam("id") Integer id){
        if(id == null){
            return teacherService.findTeacher();
        }else {
            return teacherService.findTeacherById(id).toString();
        }
    }

    @RequestMapping("update")
    public String updateTeacher(Teacher teacher){
        Teacher teacher1 = teacherService.update(teacher);
        return teacher1.toString();
    }

}