package top.bgyx.boot.basic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.bgyx.boot.basic.controller.dto.AjaxResponse;
import top.bgyx.boot.basic.entity.Article;
import top.bgyx.boot.basic.entity.ArticleReader;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @date 2021/3/6
 * @description ArticleController
 */
@RestController
@RequestMapping(value = "api/v1/articles")
@Slf4j
@Api(tags = "文章管理接口")
public class ArticleController {

    /**
     * 查询⽂章，id为URL查询参数
     *
     * @param id ⽂章id
     * @return AjaxResponse
     */
    @ApiOperation("URL传参，根据id获取⽂章")
    @GetMapping()
    public AjaxResponse getArticleByParam(@ApiParam("⽂章 id") @RequestParam("id") int id) {
            ArticleReader[] readers = {

            ArticleReader.builder().name("aaa").age(21).build(),

            ArticleReader.builder().name("bbb").age(20).build()};
            List<ArticleReader> readerList =
            Arrays.asList(readers);
            Article article = Article.builder()
            .id(id)
            .author("linfan")
            .title("Spring Boot从⼊⻔到精通")
            .content("Spring Boot从⼊⻔到精通")
            .createTime(new Date())
            .readers(readerList)
            .build();
            log.info("article: " + article);
            return AjaxResponse.success(article);
}
    /**
     * 增加一篇 Article ，使用POST方法（RequestBody 方法接收参数）
     * @param article 文章实体
     * @return AjaxRespone
     */
    @PostMapping("body")
    public AjaxResponse saveArtcile(@RequestBody Article article) {
        log.info("saveArticle" + article);
        return  AjaxResponse.success(article);
    }


    /**
     * 增加一篇 Article，@RequesParam接收参数
     * @param id id，非必需，默认值
     * @param author 作者，非必需，默认值
     * @param title  标题，必需
     * @param content  内容 ，必需
     * @param createTime 创建时间，非必需，默认值哦
     * @return AjaxResponse
     */
    @ApiOperation("URL传参新增⽂章")
    @PostMapping("param")
    public  AjaxResponse saveArticle(
            @ApiParam("⽂章id")
            @RequestParam(value = "id", defaultValue = "111", required = false)
                    int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue = "baigui",required = false)
                    String author,
            @ApiParam("标题")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime",defaultValue = "2021-03-06 14:37:11",required = false) Date createTime){
                Article article = Article.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .author(author)
                        .createTime(createTime)
                        .build();
                log.info("saveArtcile" + article);
                return AjaxResponse.success(article);
    }

    /***
     * 增加一篇Article @RequestParam 取得表单对象序列化的字符串
     * @param formData 表单对象序列化的字符串
     * @return AjaxResponse
     */
    @ApiOperation("表单请求体新增⽂章")
    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@RequestParam("formdata") String formData) {
        //表单传递的数据为字符串
        log.info("formData:" + formData);
        //用Jackson 的反序列化将字符串转为Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Article article = null;
        try{
            article = objectMapper.readValue(formData,Article.class);
            log.info("article" + article);
        }catch (JsonProcessingException e){
            e.printStackTrace();

        }
        return  AjaxResponse.success(article);
    }




}