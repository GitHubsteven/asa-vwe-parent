package pers.demo.asa.vwe.common.generator.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 绝对路径的提供者
 * @Author jet.xie
 * @Date: Created at 15:57 2019/11/6.
 */
@Setter
@Getter
@Accessors(chain = true)
public class AbsPathProvider implements IPathProvider {
    private String model;
    private String dao;
    private String mapper;
    private String service;
    private String serviceImpl;
    private String controller;
    private String parent;
    private String packageName;

    @Override
    public String servicePath() {
        return this.service;
    }

    @Override
    public String daoPath() {
        return this.dao;
    }

    @Override
    public String mapperXmlPath() {
        return this.mapper;
    }

    @Override
    public String modelPath() {
        return this.dao;
    }

    @Override
    public String ctrlPath() {
        return this.controller;
    }

    @Override
    public String serviceImplPath() {
        return this.serviceImpl;
    }

    @Override
    public String parentPath() {
        return parent;
    }

    @Override
    public String parentPackage() {
        return packageName;
    }
}