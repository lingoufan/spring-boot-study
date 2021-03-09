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
import org.springframework.web.multipart.MultipartFile;
import top.bgyx.boot.basic.controller.dto.AjaxResponse;
import top.bgyx.boot.basic.entity.Article;
import top.bgyx.boot.basic.entity.ArticleReader;
import top.bgyx.boot.basic.entity.Book;
import top.bgyx.boot.basic.entity.BookReader;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
     *
     * @param article 文章实体
     * @return AjaxRespone
     */
    @PostMapping("body")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle" + article);
        return AjaxResponse.success(article);
    }

    /**
     * 删除一篇Article， 使用DELETE方法 （RequestParam 方法接收参数 ）
     *
     * @param id 文章id
     * @return AjxResponse
     */
    @ApiOperation("URL 传参 ，根据id删除文章")
    @DeleteMapping("id")
    public AjaxResponse delArticleByparam(@ApiParam("文章 id") @PathVariable int id, String title) {
        log.info("id" + id);
        return AjaxResponse.success();
    }

    /**
     * 增加一篇 Article，@RequesParam接收参数
     *
     * @param id         id，非必需，默认值
     * @param author     作者，非必需，默认值
     * @param title      标题，必需
     * @param content    内容 ，必需
     * @param createTime 创建时间，非必需，默认值哦
     * @return AjaxResponse
     */
    @ApiOperation("URL传参新增⽂章")
    @PostMapping("param")
    public AjaxResponse saveArticle(
            @ApiParam("⽂章id")
            @RequestParam(value = "id", defaultValue = "111", required = false)
                    int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue = "baigui", required = false)
                    String author,
            @ApiParam("标题")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime", defaultValue = "2021-03-06 14:37:11", required = false) Date createTime) {
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

    @GetMapping("all")
    public AjaxResponse selectArticles() {
        ArticleReader[] readers = {
                ArticleReader.builder()
                        .name("aaa")
                        .age(15)
                        .build(),
                ArticleReader.builder()
                        .name("bbb")
                        .age(11)
                        .build(),
        };
        List<ArticleReader> readerList = Arrays.asList(readers);
        Article article = Article.builder()
                .id(111)
                .author("linfan")
                .title("SringBoot")
                .content("SpringBoot从入门到死亡")
                .createTime(new Date())
                .readers(readerList)
                .build();

        Article article2 = Article.builder()
                .id(222)
                .author("lin")
                .title("Vue.js")
                .content("Vue.js从入门到困难")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Article[] articles = {article, article2};
        List<Article> articlelist = Arrays.asList(article);

        return AjaxResponse.success(articlelist);
    }

    @GetMapping("{id}")
    public AjaxResponse getArticle(@PathVariable int id) {
        Article article = Article.builder()
                .id(id)
                .author("fan")
                .title("java从入门到放弃")
                .content("java")
                .createTime(new Date())
                .build();
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
        try {
            article = objectMapper.readValue(formData, Article.class);
            log.info("article" + article);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return AjaxResponse.success(article);
    }


    @PostMapping("upload")
    public  AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {
        //创建文件在服务器的存放路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if(!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            log.info(String.valueOf(flag));
            log.info("flag" + flag);
        }
        //生成文件在服务器的名称的前缀
        String prefixName = UUID.randomUUID().toString();
        //取得源文件名
        String originalFilename = file.getOriginalFilename();
        //从原文件名中分离出扩展名（后缀）  1111.jpg → jpg
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName = prefixName + suffixName ;
        log.info(fileName);
        //创建上传的文件对象
        File savefile = new File(path + "/" + fileName);
        try {
            file.transferTo(savefile);
        } catch (IOException e) {
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }


    @PostMapping("uploadmore")
    @ApiOperation(value = "多文件上传")
    public AjaxResponse multiFileUpload(@RequestParam("files") MultipartFile[] files,
                                        HttpServletRequest request) {
        if (files.length > 0) {
            for (MultipartFile file : files) {
                //创建文件在服务器的存放路径
                String Path = request.getServletContext().getRealPath("/uploadmore");
                log.info(Path);
                File fileDir = new File(Path + "/" );
                if (!fileDir.exists()) {
                    boolean flag = fileDir.mkdirs();
                    log.info(String.valueOf(flag));
                    log.info("flag" + flag);
                }
                //取得源文件名
                String originalFilename = file.getOriginalFilename();
                //获取文件前缀
                String prefixName = UUID.randomUUID().toString();
                //从原文件名中分离出扩展名（后缀）
                assert originalFilename != null;
                String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
                //拼接新文件名
                String fileName = prefixName + suffixName;
                log.info( fileName);
                //创建上传的文件对象
                File savefile = new File(Path + "/" + fileName);
                try {
                    file.transferTo(savefile);
                } catch (IOException e) {
                    log.info(e.getMessage());
                    AjaxResponse.failure("文件上传失败");
                }

            }
        }
        return AjaxResponse.success("文件上传成功");
    }


    @PostMapping(value = "/files")
    public AjaxResponse sourceUpload(MultipartFile[] files, HttpServletRequest request) {
        List fileNames = new ArrayList();
        YearMonth yearMonth = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for(MultipartFile file :files) {
            if(file.isEmpty()) {
                System.out.println("文件为空");
            }
            //文件重命名
            String prefixName = UUID.randomUUID().toString();
            //获取文件后缀名
            String originalFilename = file.getOriginalFilename();
            //从原文件获取后缀
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接新的文件名
            String newFileName = prefixName + suffixName;
            log.info(newFileName);
            //上传文件
            String ym = yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            int day = now.get(Calendar.DAY_OF_MONTH);
            String path = request.getServletContext().getRealPath("files/"+ym+"/"+ day + "/" + suffixName);
            log.info(path);
            File fileDir = new File(path);
            if (!fileDir.exists()){
                boolean flag = fileDir.mkdirs();
                log.info("flag:"+flag);
            }
            //创建上传文件对象
            File saveFile = new File(path + "/" + newFileName);
            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.info(e.getMessage());
                AjaxResponse.failure("文件上传失败");
            }
            fileNames.add(newFileName);
            log.info(fileNames.toString());
        }
        return AjaxResponse.success("文件上传成功");
    }
}


