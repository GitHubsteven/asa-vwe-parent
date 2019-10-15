#### 生成表的sql
1. 生成vwe_blog
```
create table vwe_blog
(
	id int auto_increment
		primary key,
	title varchar(100) null,
	author varchar(50) not null,
	createtTime timestamp default CURRENT_TIMESTAMP not null,
	creator varchar(50) not null,
	modifiedTime timestamp default CURRENT_TIMESTAMP not null,
	modifier varchar(50) not null,
	content varchar(10000) null
)；

```
2. 生成comments
```
create table vwe_comments
(
	id int auto_increment
		primary key,
	content varchar(10000) null,
	blog_id varchar(50) null,
	email varchar(50) not null,
	ref_id varchar(20) null,
	remark varchar(200) null,
	sub_comments varchar(200) null,
	createt_time timestamp default CURRENT_TIMESTAMP not null,
	creator varchar(50) not null,
	modified_time timestamp default CURRENT_TIMESTAMP not null,
	modifier varchar(50) not null
);
```
