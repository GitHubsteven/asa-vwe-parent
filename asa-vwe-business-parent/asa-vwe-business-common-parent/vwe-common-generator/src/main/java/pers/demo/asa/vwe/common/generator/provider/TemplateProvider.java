package pers.demo.asa.vwe.common.generator.provider;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import org.apache.commons.lang3.StringUtils;
import pers.demo.asa.vwe.common.generator.support.VMGConstant;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 各个模板路径，eg:/templates/entity.java.ftl
 * @Author jet.xie
 * @Date: Created at 19:33 2019/11/6.
 */
public interface TemplateProvider {

    String modelTmp();

    String DaoTmp();

    String mapperTmp();

    /**
     * default value is: "/templates/service.java.ftl"
     *
     * @return service template path
     */
    String serviceTmp();

    /**
     * default value is :"/templates/serviceImpl.java.ftl"
     *
     * @return serviceImpl template path
     */
    String serviceImplTmp();

    /**
     * default value is "/templates/controller.java.ftl"
     *
     * @return 默认为null
     */
    String ctrlTmp();

    class Default extends BaseProvider implements TemplateProvider {

        @Override
        public String modelTmp() {
            return StringUtils.isBlank(this.getModel()) ? ConstVal.TEMPLATE_ENTITY_JAVA + ".ftl"
                    : this.getModel();
        }

        @Override
        public String DaoTmp() {
            return StringUtils.isBlank(this.getDao()) ? VMGConstant.CustomTemplateUrl.VOERP_DAO
                    : this.getDao();
        }

        @Override
        public String mapperTmp() {
            return StringUtils.isBlank(this.getMapper()) ? ConstVal.TEMPLATE_XML + ".ftl"
                    : this.getMapper();
        }


        @Override
        public String serviceTmp() {
//            return StringUtils.isBlank(this.getService()) ? ConstVal.TEMPLATE_SERVICE + ".ftl"
//                    : this.getService();
            return null;
        }

        @Override
        public String serviceImplTmp() {
//            return StringUtils.isBlank(this.getServiceImpl()) ? ConstVal.TEMPLATE_SERVICE_IMPL + ".ftl"
//                    : this.getServiceImpl();
            return null;
        }

        @Override
        public String ctrlTmp() {
//            return StringUtils.isBlank(this.getController()) ? ConstVal.TEMPLATE_CONTROLLER + ".ftl"
//                    : this.getController();
            return null;
        }
    }
}