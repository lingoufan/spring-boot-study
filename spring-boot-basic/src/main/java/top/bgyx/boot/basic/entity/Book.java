package top.bgyx.boot.basic.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @date 2021/3/5
 * @description Book
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content", "title"})
public class Book {
    @JsonIgnore
    private Integer id;

    @JsonProperty("name")
    private String author;

    private String title;
    private String content;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<BookReader> readers;

}