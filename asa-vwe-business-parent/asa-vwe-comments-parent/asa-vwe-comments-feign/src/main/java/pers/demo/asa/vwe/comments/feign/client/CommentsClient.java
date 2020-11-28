package pers.demo.asa.vwe.comments.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import pers.demo.asa.vwe.comments.api.ICommentsApi;
import pers.demo.asa.vwe.comments.bean.constant.CommentsUrl;
import pers.demo.asa.vwe.comments.feign.core.FeignServiceConfiguration;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:21 2019/10/30.
 */
@FeignClient(value = "${api.comments}", path = CommentsUrl.ROOT,
        configuration = FeignServiceConfiguration.class)
public interface CommentsClient extends ICommentsApi {
}