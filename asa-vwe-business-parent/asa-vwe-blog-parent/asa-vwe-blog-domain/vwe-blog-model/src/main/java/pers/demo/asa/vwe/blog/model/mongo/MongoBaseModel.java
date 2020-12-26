package pers.demo.asa.vwe.blog.model.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class MongoBaseModel<T> {
    @Id
    private T id;

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
