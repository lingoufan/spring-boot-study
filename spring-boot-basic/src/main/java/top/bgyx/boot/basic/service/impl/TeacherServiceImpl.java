package top.bgyx.boot.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bgyx.boot.basic.dao.TeacherDAO;
import top.bgyx.boot.basic.entity.Teacher;
import top.bgyx.boot.basic.service.TeacherService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author admin
 * @date 2021/3/18
 * @description TeacherServiceImpl
 */
@Service
@Resource
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDao;
    @Override
    public boolean add(Teacher teacher){
        Teacher saveTeacher =teacherDao.save(teacher);
        return saveTeacher != null;
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherDao.saveAndFlush(teacher);
    }

    @Override
    public int delete(Integer id) {
        teacherDao.deleteById(id);
        return 0;
    }

    @Override
    public Teacher findTeacherById(Integer id) {
        Optional<Teacher> teacher = teacherDao.findById(id);
        if (teacher != null) {
            return teacher.get();
        }
        return null;
    }

    @Override
    public List<Teacher> findTeacher() {
        return teacherDao.findAll();
    }
}