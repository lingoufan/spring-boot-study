package top.bgyx.boot.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.bgyx.boot.basic.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
