package top.bgyx.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.bgyx.boot.basic.entity.Book;

import javax.annotation.Resource;
import javax.persistence.Entity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookServiceTest {
    @Resource
    private  BookService bookService;
//    @Test
//    void save() {
//    Book book = Book.builder()
//            .name("Java")
//            .cover("1.jpg")
//            .build();
//   Book savebook = bookService.save(book);
//        System.out.println("id" + savebook.getId());
//   assertEquals("Java",savebook.getName());
//    }

    @Test
    void getAll() {
        List<Book> books = bookService.getAll();
        log.info("books" + books );
        assertEquals(5 ,books.size());
    }
}