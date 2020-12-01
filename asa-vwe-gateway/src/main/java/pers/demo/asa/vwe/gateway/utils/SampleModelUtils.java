package pers.demo.asa.vwe.gateway.utils;

import pers.demo.asa.vwe.gateway.model.BaseModel;

import java.time.LocalDate;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SampleModelUtils {
    /**
     * 设置一些生成的属性
     *
     * @param model   对象
     * @param creator 生成者
     * @param <T>     对象类型
     */
    public static <T extends BaseModel> void setCreated(T model, String creator) {
        model.setCreator(creator);
        model.setModifier(creator);
        model.setCreateTime(LocalDate.now());
        model.setModifiedTime(LocalDate.now());
    }

    /**
     * 设置一些更新时的属性
     *
     * @param model   对象
     * @param updater 更新者
     * @param <T>     对象类型
     */
    public static <T extends BaseModel> void setUpdate(T model, String updater) {
        model.setModifier(updater);
        model.setModifiedTime(LocalDate.now());
    }
}
