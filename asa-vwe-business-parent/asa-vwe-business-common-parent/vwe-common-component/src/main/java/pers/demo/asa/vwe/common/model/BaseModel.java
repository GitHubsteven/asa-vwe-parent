package pers.demo.asa.vwe.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:14 2019/10/15.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BaseModel<K> implements Serializable {
    @TableId(type = IdType.AUTO)
    private K id;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String creator;
    private String modifier;
}