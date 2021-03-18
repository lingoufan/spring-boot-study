package top.bgyx.boot.basic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.bgyx.boot.basic.entity.Teacher;


public interface TeacherDAO extends JpaRepository<Teacher,Integer> {

}