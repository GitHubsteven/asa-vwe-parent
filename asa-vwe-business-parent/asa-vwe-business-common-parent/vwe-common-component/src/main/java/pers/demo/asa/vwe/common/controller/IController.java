package pers.demo.asa.vwe.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.demo.asa.vwe.common.constant.UrlConstant;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:19 2019/10/29.
 */
public interface IController<T> {
    /**
     * 增加
     *
     * @param model 增加的实例
     * @return 执行操作结果
     */
    @GetMapping(UrlConstant.DefaultUrl.ADD)
    default Boolean add(T model) {
        return false;
    }

    ;

    /**
     * 删除model
     *
     * @param id 待删除的id
     * @return 删除结果
     */
    @GetMapping(UrlConstant.DefaultUrl.DELETE_BY_ID)
    default Boolean deleteById(@PathVariable("id") String id) {
        return false;
    }

    /**
     * 通过id来更新
     *
     * @param updateModel 待更新的信息
     * @return 更新的结果
     */
    @PostMapping(UrlConstant.DefaultUrl.UPDATE_BY_ID)
    default Boolean updateBydId(@RequestBody T updateModel, @PathVariable("id") String id) {
        return false;
    }

    /**
     * 通过id来获取
     *
     * @param id id
     * @return 单个数据
     */
    @GetMapping(UrlConstant.DefaultUrl.GET_BY_ID)
    default T getById(@PathVariable("id") String id) {
        return null;
    }
}