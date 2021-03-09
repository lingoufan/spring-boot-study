package top.bgyx.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author admin
 * @date 2021/3/9
 * @description Mother
 */
@Data
@Component
@ConfigurationProperties(prefix = "family.mother")
public class Mother {
    private  List<String> alias;
}