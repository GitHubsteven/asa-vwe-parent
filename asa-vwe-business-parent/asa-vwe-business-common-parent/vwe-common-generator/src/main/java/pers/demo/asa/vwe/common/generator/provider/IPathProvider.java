package pers.demo.asa.vwe.common.generator.provider;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:09 2019/11/6.
 */
public interface IPathProvider {

    String servicePath();

    String daoPath();

    /**
     * mapper xml应该是放在resources文件夹下面
     *
     * @return mapper xml的文件路径
     */
    String mapperXmlPath();

    String modelPath();

    String ctrlPath();

    String serviceImplPath();

    String parentPath();

    /**
     * 获取包名
     *
     * @return 包名
     */
    String parentPackage();
}