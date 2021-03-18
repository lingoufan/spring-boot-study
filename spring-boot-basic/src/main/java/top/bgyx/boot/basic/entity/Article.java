package top.bgyx.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @date 2021/3/6
 * @description Article
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder(value = {"content", "title"})
@ApiModel("⽂章基本信息")
public class Article {
    //@JsonIgnore
    @ApiModelProperty("id")
    private Integer id;
    //@JsonProperty("name")
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("创建时间")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone
            = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("读者列表")
    private List<ArticleReader> readers;
}