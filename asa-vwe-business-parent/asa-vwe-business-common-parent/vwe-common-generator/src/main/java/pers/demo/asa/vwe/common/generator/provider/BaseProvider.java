package pers.demo.asa.vwe.common.generator.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 20:42 2019/11/7.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BaseProvider {
    private String model;
    private String dao;
    private String mapper;
    private String service;
    private String serviceImpl;
    private String controller;
}