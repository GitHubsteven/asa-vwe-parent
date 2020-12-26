package pers.demo.asa.vwe.blog.model.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author voerp-mybatis-generator
 * @since 2019-11-08
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString
@Document("blogmodels")
public class MBlogModel extends MongoBaseModel<String> {

    private String author;
    private String userId;
    private String context;
    private String tags;
    private String categories;

}
