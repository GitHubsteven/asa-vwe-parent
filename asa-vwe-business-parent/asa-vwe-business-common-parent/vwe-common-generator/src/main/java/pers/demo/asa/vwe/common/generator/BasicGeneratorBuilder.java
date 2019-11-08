package pers.demo.asa.vwe.common.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.base.Preconditions;
import javafx.util.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import pers.demo.asa.vwe.common.generator.provider.IPathProvider;
import pers.demo.asa.vwe.common.generator.provider.SupperClassProvider;
import pers.demo.asa.vwe.common.generator.provider.TemplateProvider;
import pers.demo.asa.vwe.common.generator.support.VMGConstant;
import pers.demo.asa.vwe.common.generator.support.VMGUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 当前只负责生成model/mapper/dao，service/controller如果要生成的话，
 * 那么就需要自己写或者在这个基础上修改相关配置
 * @Author jet.xie
 * @Date: Created at 13:14 2019/11/6.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BasicGeneratorBuilder implements Builder<AutoGenerator> {
    /*
     * 数据库源配置信息
     */
    private DataSourceConfig dataSourceConfig;
    private IPathProvider iPathProvider;
    private SupperClassProvider supperClassProvider;
    private TemplateProvider templateProvider;
    private String[] exclusiveTables;
    /*
    支持正则表达式，如"^vwe_(.*)$",
    表名"user", "session", "test"
     */
    private String[] inclusiveTables;
    /*
     * 忽略的列
     */
    private String[] ignoreColumns;
    /**
     * 要忽略的表的前缀，如oms,wms等
     */
    private String tablePrefix;

    /*
     * dao是否增加@repository注释，默认为true
     */
    private Boolean isRepository = true;


    @Override
    public AutoGenerator build() {
        checkArgs();
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(defaultGlobalConfig())
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig())
                .setCfg(defaultInject())
                .setTemplate(defaultTempCfg())
                .setStrategy(defaultStrategyCfg())
                .setTemplateEngine(new FreemarkerTemplateEngine());
        return generator;
    }

    private void checkArgs() {
        // 路径提供不能为空
        Preconditions.checkNotNull(iPathProvider, "ipathProvider不能为空!");
        // 数据源不能为空
        Preconditions.checkNotNull(dataSourceConfig, "dataSourceConfig不能为空!");
        if (templateProvider == null) templateProvider = new TemplateProvider.Default();
    }

    /**
     * 默认是不生成的，因为我们要用自己的代替
     *
     * @return 默认的模板路径
     */
    private TemplateConfig defaultTempCfg() {
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null)
                .setXml(null)
                .setMapper(null).setEntity(null)
                .setService(null).setServiceImpl(null)
                .setEntityKt(null);
        return tc;
    }

    private GlobalConfig defaultGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        if (iPathProvider != null) {
            globalConfig.setOutputDir(iPathProvider.parentPath());
        }
        globalConfig.setAuthor("voerp-mybatis-generator")
                .setEntityName("%sModel")
                .setMapperName("%sDao")
                .setBaseResultMap(true)
                .setOpen(false);
        return globalConfig;
    }

    private PackageConfig packageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //如果需要，请自定义
        pc.setParent(this.iPathProvider.parentPackage());
        pc.setEntity("model");
        pc.setMapper("dao");
        return pc;
    }

    private InjectionConfig defaultInject() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put(VMGConstant.CustomInjectArgsKey.SUPPER_ENTITY_CARD_ARG, "Long");
                map.put(VMGConstant.CustomInjectArgsKey.IS_REPOSITORY, isRepository);
                map.put(VMGConstant.CustomInjectArgsKey.IS_EXCLUDE_MP, Boolean.TRUE);
                this.setMap(map);
            }
        };
        injectionConfig.setFileOutConfigList(buildFileOutCfg());
        return injectionConfig;
    }

    private List<FileOutConfig> buildFileOutCfg() {
        List<FileOutConfig> focList = new ArrayList<>();
        //model
        VMGUtils.addNotNull(focList, createFileOutCfg(templateProvider.modelTmp(), iPathProvider.modelPath(),
                (tableInfo) -> tableInfo.getEntityName() + StringPool.DOT_JAVA
        ));
        //dao
        VMGUtils.addNotNull(focList, createFileOutCfg(templateProvider.DaoTmp(), iPathProvider.daoPath(),
                (tableInfo -> tableInfo.getEntityName().replace("Model", "Dao")
                        + StringPool.DOT_JAVA)));
        //mapper
        VMGUtils.addNotNull(focList, createFileOutCfg(templateProvider.mapperTmp(), iPathProvider.mapperXmlPath(),
                (tableInfo -> tableInfo.getEntityName().replace("Model", "ExtMapper")
                        + StringPool.DOT_XML)));
        return focList;
    }

    /**
     * 文件绝对路径的生成
     *
     * @param templateUrl 模板的地址
     * @param tmpOutPut   输出地址
     * @param nameRuler   命名规则
     * @return 绝对路径
     */
    private FileOutConfig createFileOutCfg(String templateUrl, String tmpOutPut, Function<TableInfo, String> nameRuler) {
        if (StringUtils.isBlank(templateUrl)) return null;
        return new FileOutConfig(templateUrl) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return tmpOutPut + VMGConstant.PATH_SEPARATOR + nameRuler.apply(tableInfo);
            }
        };
    }

    // 默认策略配置
    private StrategyConfig defaultStrategyCfg() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        if (supperClassProvider != null) {
            strategy.setSuperEntityClass(supperClassProvider.modelName());
            strategy.setSuperMapperClass(supperClassProvider.daoName());
            strategy.setSuperServiceClass(supperClassProvider.serviceName());
            strategy.setSuperServiceImplClass(supperClassProvider.serviceImplName());
            strategy.setSuperControllerClass(supperClassProvider.controllerName());
        }
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(this.ignoreColumns);
        strategy.setInclude(this.inclusiveTables);
        strategy.setExclude(this.exclusiveTables);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(false);
        if (StringUtils.isNotBlank(tablePrefix))
            strategy.setTablePrefix(tablePrefix + "_");
        return strategy;
    }

}