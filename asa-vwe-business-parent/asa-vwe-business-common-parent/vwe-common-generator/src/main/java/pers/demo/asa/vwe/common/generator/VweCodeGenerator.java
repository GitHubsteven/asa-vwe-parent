package pers.demo.asa.vwe.common.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.fasterxml.jackson.databind.util.ConstantValueInstantiator;
import pers.demo.asa.vwe.common.generator.provider.RelPathProvider;
import pers.demo.asa.vwe.common.generator.provider.SupperClassProvider;
import pers.demo.asa.vwe.common.generator.provider.TemplateProvider;
import pers.demo.asa.vwe.common.generator.support.VMGConstant;
import pers.demo.asa.vwe.common.model.BaseModel;


/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:36 2019/10/25.
 */
public class VweCodeGenerator {
    private static String DATASOURCE_URL = "jdbc:mysql://127.0.0.1:3306/asa_vwe?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String pwd = "123456";

    public static void main(String[] args) {
        //数据库配置
        DataSourceConfig dsf = new DataSourceConfig();
        dsf.setUrl(DATASOURCE_URL)
                .setDriverName(VMGConstant.MYSQL_DRIVER_NAME)
                .setUsername(username)
                .setPassword(pwd);
        //路径配置
        RelPathProvider pathProvider = new RelPathProvider();
        pathProvider.setUserDir(System.getProperty("user.dir"))
                .setParentPackage("pers.demo.asa.vwe.blog")
                .withParentModuleChain("asa-vwe-business-parent", "asa-vwe-blog-parent")
                .withDaoModuleChain("asa-vwe-business-parent", "asa-vwe-blog-parent","asa-vwe-blog-dao")
                .withMapperModuleChain("asa-vwe-business-parent", "asa-vwe-blog-parent","asa-vwe-blog-dao")
                .withModelModuleChain("asa-vwe-business-parent", "asa-vwe-blog-parent", "asa-vwe-blog-domain", "vwe-blog-model");
        //supperClassProvider
        SupperClassProvider supperClzProvider = new SupperClassProvider();
        supperClzProvider.setModel(BaseModel.class);
        supperClzProvider.setDao(null);
        //ignore super columns "id", "creator", "createTime", "modifier", "modifyTime"
        String[] ignoreSuperFields = {"id", "creator", "createTime", "modifier", "modifyTime"};
//        ^vwe_(.*)$
        String[] inclusive = {"vwe_blog"};
        BasicGeneratorBuilder builder = new BasicGeneratorBuilder();
        AutoGenerator generator = builder.setDataSourceConfig(dsf)
                .setIPathProvider(pathProvider)
                .setSupperClassProvider(supperClzProvider)
                .setIgnoreColumns(ignoreSuperFields)
                .setInclusiveTables(inclusive)
                .setTablePrefix("vwe")
                .build();
        generator.execute();

    }
}