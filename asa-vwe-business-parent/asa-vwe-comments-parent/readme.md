##### 
在导入mybatis-plus-boot-starter后，生成的xml的自定义sql函数为什么找不到？

可能的情形如下：
1. mapper.xml文件没有打包到文件中，如果没有的话，建议在pom中加入如下代码 
```xml
<resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*</include>
                </includes>
            </resource>
        </resources>
```
2. 没有定义mybatis-plus的.xml的路径，在application.yml中加入如下代码： 
```yml
#mybatis-plus config:
mybatis-plus:
  mapper-locations: classpath*:pers/demo/asa/vwe/comments/mapper/**/*.xml
```
