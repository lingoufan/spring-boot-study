package top.bgyx.boot.basic.service;


import top.bgyx.boot.basic.entity.Book;

import java.util.List;

/**
 * @author admin
 */
public interface BookService {
    /**
     * 新增Book
     * @param book 入参
     * @return 新增book对象
    **/
    Book save (Book book);
    /**
     *查询所有book
     *
     * @return 图书集合
     * **/
    List<Book> getAll();
}
