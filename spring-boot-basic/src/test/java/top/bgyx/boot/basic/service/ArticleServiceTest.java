package top.bgyx.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bgyx.boot.basic.entity.Article;
import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ArticleServiceTest {

    @Resource
    private  ArticleService articleService;

    @Test
    void  postArticle(){
        Article article = Article.builder()
                .title("111")
                .content("111")
                .author("111")
                .build();
        log.info("article"+article);
        boolean flag = articleService.postArticle(article);
        log.info("flag:" + flag);
        assertTrue(flag);
    }

}