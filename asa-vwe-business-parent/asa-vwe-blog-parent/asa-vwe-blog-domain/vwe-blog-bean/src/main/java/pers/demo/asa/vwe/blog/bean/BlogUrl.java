package pers.demo.asa.vwe.blog.bean;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:56 2019/10/10.
 */
public class BlogUrl {
    public static final String ROOT = "/blog";

    public interface Blog {
        String LIST = "/list";
        String GET_BLOG_COMMENTS = "/blog-with-comments/{id}";
    }
}