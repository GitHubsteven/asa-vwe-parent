#### 生成表的sql
1. 生成vwe_blog
```
CREATE TABLE IF NOT EXISTS vwe_blog
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  title       VARCHAR(100)                        NULL,
  author      VARCHAR(50)                         NOT NULL,
  context     VARCHAR(10000)                      NOT NULL,
  categories     VARCHAR(200)                      NULL,
  tags     VARCHAR(200)                      NULL,
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
生成users
```
CREATE TABLE IF NOT EXISTS vwe_comments
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  username      VARCHAR(10000)                     NOT NULL,
  hash          VARCHAR(50)                         NULL,
  email        VARCHAR(50)                         NOT NULL,
  password       VARCHAR(20)                       NOT  NULL,
  role       VARCHAR(200)                        NOT NULL,
  create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  creator      VARCHAR(50)                         NOT NULL,
  modify_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  modifier     VARCHAR(50)                         NOT NULL
);
```