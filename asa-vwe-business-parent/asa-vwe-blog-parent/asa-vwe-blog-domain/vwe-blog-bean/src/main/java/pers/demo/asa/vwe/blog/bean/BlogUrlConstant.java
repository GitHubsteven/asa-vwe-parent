package pers.demo.asa.vwe.blog.bean;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:56 2019/10/10.
 */
public class BlogUrlConstant {
    String ROOT = "/blog";

    public interface Blog {
        String LIST_BLOG = "/blog-list";
        String GET_BLOG_BY_ID = "/getById/{id}";
        String CREATE_BLOG = "/blog-create";
        String DELETE_BLOG = "/blog-create";
        String UPDATE_BLOG = "/blog-update/{id}";
    }
}