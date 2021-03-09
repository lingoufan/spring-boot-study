package top.bgyx.boot.basic.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2021/3/9
 * @description FileSize
 */

@Data
@Component
public class FileSize {
    @Value("300MB")
    private String maxSize;



}