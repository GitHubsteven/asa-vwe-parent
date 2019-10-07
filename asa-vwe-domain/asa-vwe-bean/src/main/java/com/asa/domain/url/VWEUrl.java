package com.asa.domain.url;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
 */
public class VWEUrl {
    public interface Article {
        String LIST_BLOG = "/blog-list";
        String GET_BLOG_BY_ID = "/blog-view/{id}";
        String CREATE_BLOG = "/blog-create";
        String DELETE_BLOG = "/blog-create";
        String UPDATE_BLOG = "/blog-update/{id}";
    }

    public interface Comment {
        String GET_COMMENTS_BY_BLOG_ID = "/blog-comments/{blogId}";
        String CREATE_COMMENT = "/comments-create/";
        String GET_SUB_COMMENTS = "/comment-getSubs/{blogId}/{commentId}";
    }

    public interface User {
        String REGISTER_USER = "/user-register";
        String LOGIN = "/user-login";
    }
}
