#### 生成表的sql
1. 生成vwe_blog
```
CREATE TABLE IF NOT EXISTS vwe_blog
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  title       VARCHAR(100)                        NULL,
  author      VARCHAR(50)                         NOT NULL,
  content     VARCHAR(10000)                      NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  creator     VARCHAR(50)                         NOT NULL,
  modify_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  modifier    VARCHAR(50)                         NOT NULL
);

```
2. 生成comments
```
CREATE TABLE IF NOT EXISTS vwe_comments
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  content      VARCHAR(10000)                      NULL,
  blog_id      VARCHAR(50)                         NULL,
  email        VARCHAR(50)                         NOT NULL,
  ref_id       VARCHAR(20)                         NULL,
  remark       VARCHAR(200)                        NULL,
  sub_comments VARCHAR(200)                        NULL,
  create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  creator      VARCHAR(50)                         NOT NULL,
  modify_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  modifier     VARCHAR(50)                         NOT NULL
);
```
