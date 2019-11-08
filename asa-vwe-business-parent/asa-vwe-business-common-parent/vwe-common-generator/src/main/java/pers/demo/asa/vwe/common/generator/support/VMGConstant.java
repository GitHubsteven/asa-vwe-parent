package pers.demo.asa.vwe.common.generator.support;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:22 2019/11/6.
 */
public class VMGConstant {
    public static String PATH_SEPARATOR = "/";
    public static String SRC_MAIN_JAVA = "/src/main/java";
    public static String SRC_MAIN_RESOURCE = "/src/main/resources";
    public static String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 直接的包名
     */
    public interface DirPackageName {
        String MODEL = "model";
        String DAO = "dao";
        String MAPPER = "mapper";
        String SERVICE = "service";
        String SERVICE_IMPL = "service.impl";
        String CONTROLLER = "ctrl";
    }

    /**
     * 自定义的模板路径
     */
    public interface CustomTemplateUrl {
        String VOERP_MODEL = "/template/voerpModel.java.ftl";
        String VOERP_DAO = "/template/voerpDao.java.ftl";
        String VOERP_MAPPER = "/templates/mapper.xml.ftl";
    }

    /**
     * 自定义的一些可能使用到的key
     */
    public interface CustomInjectArgsKey {
        String SUPPER_ENTITY_CARD_ARG = "supperEntityCardArg";
        String SUPPER_ENTITY_CARD_ARG_NAME = "supperEntityCardArgName";
        String SUPPER_DAO_CARD_ARG = "supperDaoCardArg";
        String SUPPER_DAO_CARD_ARG_NAME = "supperDaoCardArgName";
        String IS_REPOSITORY = "isRepository";
        String IS_EXCLUDE_MP = "isExcludeMp";    //排除mybatis plus的相关
    }
}