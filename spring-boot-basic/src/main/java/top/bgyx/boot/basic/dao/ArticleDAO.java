package top.bgyx.boot.basic.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.bgyx.boot.basic.entity.Article;

import javax.annotation.Resource;


/**
 * @author admin
 * @date 2021/3/16
 * @description ArticleDAO
 */
@Repository
public class ArticleDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Article save(Article article) {
        String sql = "INSERT INTO t_article (author,title,content) VALUES (?,?,?)";
        Object[] args = {article.getAuthor(), article.getTitle(), article.getContent()};
        int count = jdbcTemplate.update(sql,args);
        //jdbcTemplate.update()
        if (count == 1) {
            return article;
        }else {
            return null;
        }
    }
//    /**
//     *
//     * */
//    public int  deleteById(Integer id) {
//        return jdbcTemplate.update(sql:"DELETE  FROM t_article WHERE id = ?", id);
//    }
}