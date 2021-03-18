package top.bgyx.boot.basic.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.bgyx.boot.basic.entity.Article;
import top.bgyx.boot.basic.entity.Student;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StudentDAO {


    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<Student> listStudents() {
        String sql = "SELECT * FROM t_student WHERE deleted=0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

    }

    public List<Student> getStudentById(Integer id) {
        String sql = "SELECT * FROM t_student WHERE id=? and deleted = 0";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student save(Student student) {
        String sql = "INSERT INTO t_student (id,name,nickname,hometown,birthday,constellation,mobile,qq,hobby ) VALUES (?,?,?,?,?,?,?,?,?) ";
        Object[] args = {student.getId(), student.getName(), student.getNickname(),
                student.getHometown(), student.getBirthday(), student.getConstellation(), student.getMobile()
                , student.getQq(), student.getHobby()};
        int count = jdbcTemplate.update(sql, args);
        if (count == 1) {
            return student;
        } else {
            return null;
        }
    }

//    String sql = "INSERT INTO t_student (`name`,github_name,nickname," +
//            "hometown,birthday,constellation,mobile,qq," +
//            "email,avatar,github,hobby,signature,color," +
//            "create_time,update_time,deleted) " +
//            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
//    Object[] args = {student.getName(), student.getGithubName(), student.getNickName(),
//            student.getHometown(), student.getBirthday(), student.getConstellation(), student.getMobile(), student.getQq(),
//            student.getEmail(), student.getAvatar(), student.getGithub(), student.getHobby(), student.getSignature(), student.getColor(),
//            student.getCreateTime(), student.getUpdateTime(), student.getDeleted()};
//    int count = jdbcTemplate.update(sql, args);
//        if (count == 1) {
//        return student;
//    } else {
//        return null;
//    }
//}


//    /*更新学生信息（昵称，爱好，手机号，qq号）*/
//    public int updateStudent(Student student) {
//        String sql = "UPDATE t_student SET nickname = ?,mobile=?,qq=?,hobby=?  WHERE id=?";
//        Object[] args = {student.getNickname(), student.getMobile(),
//                student.getHobby(),student.getQq(),student.getId()};
//        return jdbcTemplate.update(sql, args);
//    }
    /*修改学生个人信息*/
    public int updateStudent(Student student) {
        String sql = "UPDATE t_student SET nickname = ?,hometown = ?, mobile = ? ,qq=? WHERE id=? ";
        Object[] args = {student.getNickname(),student.getHometown(),student.getMobile(),student.getQq(),student.getId()};
        return jdbcTemplate.update(sql,args);
    }
    /* 删除学生信息*/
    public int deleteStudent(Integer id) {
        String sql = " UPDATE t_student SET deleted = 1 WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}