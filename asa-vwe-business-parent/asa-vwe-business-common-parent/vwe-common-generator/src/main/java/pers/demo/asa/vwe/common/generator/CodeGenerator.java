package pers.demo.asa.vwe.common.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:36 2019/10/25.
 */
public class CodeGenerator {
    private static String DATASOURCE_URL = "jdbc:mysql://127.0.0.1:3306/asa_vwe?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String PATH_SEPARATOR = "/";
    static String PARENT_PACKAGE = "pers.demo.asa.vwe.comments";
    private static String ENTITY_SUFFIX = "Model";
    //    String
    static String SRC_MAIN_JAVA = "/src/main/java";
    static String SRC_MAIN_RESOURCE = "/src/main/resources";
    static String MODULE_NAME = "vwe";   //vwe

    //必填
    private static String[] main_project = {"asa-vwe-business-parent", "asa-vwe-comments-parent"};

    //model
    static String[] model_module_chain = concat(main_project, "asa-vwe-comments-domain", "vwe-comments-model");
    //dao
    private static String[] dao_module_chain = concat(main_project, "asa-vwe-comments-dao");
    //mapper
    private static String[] mapper_module_chain = concat(main_project, "asa-vwe-comments-dao");
    //service
    private static String[] service_module_chain = concat(main_project, "asa-vwe-comments-service");
    //controller
    private static String[] controller_module_chain = concat(main_project, "asa-vwe-comments-api-impl");
    //"^vwe_(.*)$"
    private static String[] tables = {"vwe_comments"};
    private static String[] ignore_columns = {"id", "creator", "create_time", "modifier", "modify_time"};

    //选填
    private static String model_super_class = "pers.demo.asa.vwe.common.model.BaseModel";
    private static String controller_super_class = null;  //pers.demo.asa.vwe.common.controller.BaseController
    private static String service_super_class = null;  //pers.demo.asa.vwe.common.service.IBaseService
    private static String service_impl_super_class = "";  //pers.demo.asa.vwe.common.service.impl.BaseServiceImpl
    private static String main_project_path;

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String userDir = System.getProperty("user.dir");
        main_project_path = userDir + PATH_SEPARATOR + String.join("/", main_project);
        gc.setOutputDir(main_project_path + SRC_MAIN_JAVA);
        gc.setAuthor("asa.x");

        gc.setEntityName("%s" + ENTITY_SUFFIX);
        gc.setMapperName("%sDao");
        gc.setControllerName("%sImplCtrl");
        gc.setServiceName("I%sService");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = getDataSourceConfig();
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //MODULE_NAME
        pc.setParent(PARENT_PACKAGE);
        pc.setEntity("model");
        pc.setMapper("dao");
        pc.setController("api.impl");  //修改日期：2019-10-31

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = getFileOutConfigs(userDir, templatePath);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null)
                .setEntity(null)
                .setController(null)
                .setService(null)
                .setServiceImpl(null)
                .setMapper(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(model_super_class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(controller_super_class);
        strategy.setSuperServiceImplClass(service_impl_super_class);
        strategy.setSuperServiceClass(service_super_class);
        // 写于父类中的公共字段

        strategy.setSuperEntityColumns(ignore_columns);
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(MODULE_NAME + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATASOURCE_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        return dsc;
    }

    private static List<FileOutConfig> getFileOutConfigs(String userDir, String templatePath) {
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出，extMapper.xml路径
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String mapperXmlPath = buildPath(userDir,
                        dao_module_chain,
                        SRC_MAIN_RESOURCE,
                        PARENT_PACKAGE,
                        null,
                        "mapper");
                return mapperXmlPath
                        + PATH_SEPARATOR
                        + tableInfo.getEntityName().replace(ENTITY_SUFFIX, "ExtMapper")
                        + StringPool.DOT_XML;
            }
        });
        //model路径
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelPath = buildPath(userDir,
                        model_module_chain,
                        SRC_MAIN_JAVA,
                        PARENT_PACKAGE,
                        "",
                        "model");
                return modelPath + PATH_SEPARATOR + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        //service 路径
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelPath = buildPath(userDir,
                        service_module_chain,
                        SRC_MAIN_JAVA,
                        PARENT_PACKAGE,
                        "",
                        "service");
                return modelPath + PATH_SEPARATOR
                        + "I"
                        + tableInfo.getEntityName().replace("Model", "Service")
                        + StringPool.DOT_JAVA;
            }
        });

        //service impl 路径
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelPath = buildPath(userDir,
                        service_module_chain,
                        SRC_MAIN_JAVA,
                        PARENT_PACKAGE,
                        "",
                        "service/impl");
                return modelPath + PATH_SEPARATOR
                        + tableInfo.getEntityName().replace("Model", "ServiceImpl")
                        + StringPool.DOT_JAVA;
            }
        });


        //controller 路径
        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelPath = buildPath(userDir,
                        controller_module_chain,
                        SRC_MAIN_JAVA,
                        PARENT_PACKAGE,
                        "",
                        "api/impl");
                return modelPath
                        + PATH_SEPARATOR
                        + tableInfo.getEntityName().replace("Model", "ImplCtrl")
                        + StringPool.DOT_JAVA;
            }
        });
        //dao 路径
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelPath = buildPath(userDir,
                        mapper_module_chain,
                        SRC_MAIN_JAVA,
                        PARENT_PACKAGE,
                        "",
                        "dao");
                return modelPath
                        + PATH_SEPARATOR
                        + tableInfo.getEntityName().replace("Model", "Dao")
                        + StringPool.DOT_JAVA;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        return focList;
    }


    /**
     * 构建生成文件的路径
     *
     * @param usrDir      userDir的路径
     * @param modules     模块路径链，入parent,submodule
     * @param srcMain     主包名，如src/main/java,src/main/resources
     * @param packageName 包名，如com.sun.javax
     * @param moduleName  直接的子模块名称，如vwe，可以为空
     * @param dirPackage  最后的包，如model,service,controller
     * @return 文件的生成路径
     */
    public static String buildPath(String usrDir, String[] modules, String srcMain,
                                   String packageName, String moduleName, String dirPackage) {
        List<String> totalPath = new ArrayList<>();
        totalPath.add(usrDir);
        Collections.addAll(totalPath, modules);
        totalPath.add(srcMain);
        String[] packagePaths = packageName.split("\\.");
        Collections.addAll(totalPath, packagePaths);
        totalPath.add(moduleName);
        totalPath.add(dirPackage);
        String pathTmp = totalPath.stream().filter(StringUtils::isNotEmpty)
                .collect(Collectors.joining("/"));
        //去除//
        pathTmp = pathTmp.replaceAll("//", "/");
        return pathTmp;

    }

    /**
     * 数组拼接
     *
     * @param first  第一个数组
     * @param append 后续数组
     * @param <T>    类型
     * @return 拼接后的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] concat(T[] first, T... append) {
        Object[] result = new Object[first.length + append.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(append, 0, result, first.length, append.length);
        return (T[]) Arrays.copyOf(result, result.length, first.getClass());
    }
}