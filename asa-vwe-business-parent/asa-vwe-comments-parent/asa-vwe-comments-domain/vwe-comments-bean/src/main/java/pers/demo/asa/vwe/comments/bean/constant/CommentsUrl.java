package pers.demo.asa.vwe.comments.bean.constant;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:15 2019/12/4.
 */
public class CommentsUrl {
    public static final String ROOT = "/comments";

    public interface Comments {
        String LIST_BLOG_COMMENTS = "/list-comments/{blogId}";
        String COUNT_COMMENTS = "/count-comments/{blogId}";
    }
}