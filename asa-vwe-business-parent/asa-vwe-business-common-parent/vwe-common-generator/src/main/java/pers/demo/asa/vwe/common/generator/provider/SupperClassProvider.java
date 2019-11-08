package pers.demo.asa.vwe.common.generator.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:49 2019/11/6.
 */
@Setter
@Getter
@Accessors(chain = true)
public class SupperClassProvider {
    private Class<?> model;
    private Class<?> dao;
    private Class<?> service;
    private Class<?> serviceImpl;
    private Class<?> controller;

    public String modelName() {
        return model == null ? null : model.getName();
    }

    public String daoName() {
        return dao == null ? null : dao.getName();
    }

    public String serviceImplName() {
        return serviceImpl == null ? null : serviceImpl.getName();
    }

    public String serviceName() {
        return service == null ? null : service.getName();
    }

    public String controllerName() {
        return controller == null ? null : controller.getName();
    }

}