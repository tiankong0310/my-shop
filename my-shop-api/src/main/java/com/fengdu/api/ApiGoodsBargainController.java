package com.fengdu.api;

import com.fengdu.annotation.IgnoreAuth;
import com.fengdu.annotation.LoginUser;
import com.fengdu.entity.GoodsBargainVo;
import com.fengdu.entity.UserVo;
import com.fengdu.service.ApiGoodsBargainService;
import com.fengdu.util.ApiBaseAction;
import com.fengdu.util.ApiPageUtils;
import com.fengdu.utils.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@RestController
@RequestMapping("/api/bargain")
public class ApiGoodsBargainController extends ApiBaseAction {
    @Autowired
    private ApiGoodsBargainService apiGoodsBargainService;

    /**
     */
    @IgnoreAuth
    @RequestMapping("list")
    public Object list(@LoginUser UserVo loginUser, @RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map param = new HashMap();
        param.put("page", page);
        param.put("limit", size);
        param.put("sidx", "id");
        param.put("order", "desc");
        //查询列表数据
        Query query = new Query(param);
        List<GoodsBargainVo> topicEntities = apiGoodsBargainService.queryList(query);
        int total = apiGoodsBargainService.queryTotal(query);
        ApiPageUtils pageUtil = new ApiPageUtils(topicEntities, total, query.getLimit(), query.getPage());
        return toResponsSuccess(pageUtil);
    }
}