package top.bgyx.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)


class FileSizeTest {
    @Resource
    private FileSize fileSize;

    @Test
    void getMaxSize(){
        log.info("filesize:" + fileSize.getMaxSize());
        String maxSize = fileSize.getMaxSize();
        assertEquals("300MB",maxSize);
    }
}