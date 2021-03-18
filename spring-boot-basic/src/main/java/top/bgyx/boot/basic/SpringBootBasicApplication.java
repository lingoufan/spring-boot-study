package top.bgyx.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

    }
