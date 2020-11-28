package pers.demo.asa.vwe.blog.model.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author voerp-mybatis-generator
 * @since 2019-11-08
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString
@Document("blogmodels")
public class BlogModel {
    @Id
    private String id;
    private String author;
    private String userId;
    private String context;
    private String tags;
    private String categories;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
