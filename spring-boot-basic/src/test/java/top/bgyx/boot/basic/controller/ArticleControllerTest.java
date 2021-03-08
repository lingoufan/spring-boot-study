package top.bgyx.boot.basic.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
class ArticleControllerTest {
    @Resource
    private  MockMvc mockMvc;

    //mock 对象
    //private static  MocMvc mockMvc;

//    //在所有测试⽅法执⾏之前进⾏mock对象初始化
//    @BeforeAll
//    static void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }
    @Test
    void saveArticle() throws Exception {
        String article = "{\n" + " \"id\": 1,\n" +
                " \"author\": \"linfan\",\n" +
                " \"title\": \"Spring Boot从⼊⻔到精通\",\n" +
                " \"content\": \"Spring Boot从⼊⻔到精通\",\n" +
                " \"createTime\": \"2021-03-06 15:23:34\",\n" +
                " \"readers\": [{\"name\":\"aaa\",\"age\":21}, {\"name\":\"bbb\",\"age\":20}]\n" +
                "}";
            MvcResult result = mockMvc.perform(
                    MockMvcRequestBuilders
                            .request(HttpMethod.POST, "/api/v1/articles/body")
                            .contentType("application/json")
                            .content(article)
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("linfan"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(21))
                .andDo(print())
                .andReturn();
            result.getResponse().setCharacterEncoding("UTF8");

            log.info(result.getResponse().getContentAsString());
        }
    }