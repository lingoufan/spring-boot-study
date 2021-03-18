package top.bgyx.boot.basic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bgyx.boot.basic.entity.Book;
import top.bgyx.boot.basic.repository.BookRepository;
import top.bgyx.boot.basic.service.BookService;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author admin
 * @date 2021/3/18
 * @description BookServiceImpl
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}