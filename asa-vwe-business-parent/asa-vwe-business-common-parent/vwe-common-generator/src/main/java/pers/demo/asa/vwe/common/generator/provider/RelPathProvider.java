package pers.demo.asa.vwe.common.generator.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import pers.demo.asa.vwe.common.generator.support.VMGConstant;
import pers.demo.asa.vwe.common.generator.support.VMGUtils;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 相对路径描述
 * @Author jet.xie
 * @Date: Created at 16:03 2019/11/6.
 */
@Setter
@Getter
@Accessors(chain = true)
public class RelPathProvider implements IPathProvider {

    private String userDir;
    /**
     * 共同的父module，如果子module不设的话，那么默认为这个
     */
    private String[] parentModuleChain;
    private String[] modelModuleChain;
    private String[] daoModuleChain;
    private String[] mapperModuleChain;
    private String[] serviceModuleChain;
    private String[] serviceImplModuleChain;
    private String[] ctrlModuleChain;
    /*
    最直接的上层包名称，等于具体包名称减去
     */
    private CusDirPkg cusDirPkg = new CusDirPkg();

    /*
     * controller 的别称，因为这个比较特殊，才写的
     */
    private String ctrlAlias;
    /*
    共同的包名，一般为parentPackage.Module|dao|mapper...
     */
    private String parentPackage;
    /**
     * 介于packageName和dirPkgName(model|service)之间
     */
    private String subModuleName;

    @Override
    public String servicePath() {
        return commonBuild(serviceModuleChain, cusDirPkg.getService());
    }

    @Override
    public String daoPath() {
        return commonBuild(daoModuleChain, cusDirPkg.getDao());
    }

    @Override
    public String mapperXmlPath() {
        if (mapperModuleChain == null) mapperModuleChain = parentModuleChain;
        return VMGUtils.buildPath(this.userDir, mapperModuleChain,
                VMGConstant.SRC_MAIN_RESOURCE, parentPackage, cusDirPkg.getMapper());
    }

    @Override
    public String modelPath() {
        return commonBuild(modelModuleChain, cusDirPkg.getModel());
    }

    @Override
    public String ctrlPath() {
        if (StringUtils.isBlank(ctrlAlias)) ctrlAlias = cusDirPkg.getController();
        return commonBuild(modelModuleChain, ctrlAlias);
    }

    @Override
    public String serviceImplPath() {
        return commonBuild(modelModuleChain, VMGConstant.DirPackageName.SERVICE_IMPL);
    }

    /**
     * 相对路径转化为绝对路径
     *
     * @param detailModuleChain 详细的路径，可以为空
     * @param dirPkgName        父包的名称，如service,dao,model
     * @return 绝对路径
     */
    public String commonBuild(String[] detailModuleChain, String dirPkgName) {
        if (detailModuleChain == null) {
            detailModuleChain = parentModuleChain;
        }
        return VMGUtils.buildPath(userDir, detailModuleChain, VMGConstant.SRC_MAIN_JAVA,
                parentPackage, subModuleName, dirPkgName);
    }

    @Override
    public String parentPath() {
        if (parentModuleChain == null || parentModuleChain.length == 0) return userDir;
        return userDir
                + VMGConstant.PATH_SEPARATOR
                + String.join(VMGConstant.PATH_SEPARATOR, parentModuleChain);
    }

    @Override
    public String parentPackage() {
        return parentPackage;
    }

    public RelPathProvider withParentModuleChain(String... parentModuleChain) {
        this.parentModuleChain = parentModuleChain;
        return this;
    }

    public RelPathProvider withModelModuleChain(String... modelModuleChain) {
        this.modelModuleChain = modelModuleChain;
        return this;
    }

    public RelPathProvider withDaoModuleChain(String... daoModuleChain) {
        this.daoModuleChain = daoModuleChain;
        return this;
    }

    public RelPathProvider withMapperModuleChain(String... mapperModuleChain) {
        this.mapperModuleChain = mapperModuleChain;
        return this;
    }

    public RelPathProvider withServiceModuleChain(String... serviceModuleChain) {
        this.serviceModuleChain = serviceModuleChain;
        return this;
    }

    public RelPathProvider withServiceImplModuleChain(String... serviceImplModuleChain) {
        this.serviceImplModuleChain = serviceImplModuleChain;
        return this;
    }

    public RelPathProvider withCtrlModuleChain(String... ctrlModuleChain) {
        this.ctrlModuleChain = ctrlModuleChain;
        return this;
    }

    @Setter
    @Getter
    public static class CusDirPkg extends BaseProvider {
        public CusDirPkg() {
            setModel(VMGConstant.DirPackageName.MODEL);
            setDao(VMGConstant.DirPackageName.DAO);
            setMapper(VMGConstant.DirPackageName.MAPPER);
            setService(VMGConstant.DirPackageName.SERVICE);
            setServiceImpl(VMGConstant.DirPackageName.SERVICE_IMPL);
            setController(VMGConstant.DirPackageName.CONTROLLER);
        }
    }
}