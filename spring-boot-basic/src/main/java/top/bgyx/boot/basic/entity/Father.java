package top.bgyx.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * @author admin
 * @date 2021/3/9
 * @description Father
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Father {
    @NotEmpty
    private String  name;
    @Min(25)
    private  Integer age;
}