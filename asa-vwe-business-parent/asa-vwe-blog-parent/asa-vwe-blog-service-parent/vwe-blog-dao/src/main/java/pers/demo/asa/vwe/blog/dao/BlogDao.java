package pers.demo.asa.vwe.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.demo.asa.vwe.blog.model.VWEBlogModel;

@Mapper
public interface BlogDao extends BaseDao<VWEBlogModel> {

}
