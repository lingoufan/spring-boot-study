package top.bgyx.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author admin
 * @date 2021/3/18
 * @description Person
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    /**
     * id, 主键
     */
    private Integer id;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 姓名
     */
    private String name;
}