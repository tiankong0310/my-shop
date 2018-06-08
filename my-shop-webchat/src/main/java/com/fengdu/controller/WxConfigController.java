package com.fengdu.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengdu.entity.WxConfigEntity;
import com.fengdu.service.WxConfigService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:38
 */
@Controller
@RequestMapping("wxconfig")
public class WxConfigController {
    @Autowired
    private WxConfigService wxConfigService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxconfig:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxConfigEntity> wxConfigList = wxConfigService.queryList(query);
        int total = wxConfigService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxConfigList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxconfig:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxConfigEntity wxConfig = wxConfigService.queryObject(id);

        return R.ok().put("wxConfig", wxConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxconfig:save")
    @ResponseBody
    public R save(@RequestBody WxConfigEntity wxConfig) {
        wxConfig.setId( IdUtil.createIdbyUUID());
        wxConfigService.save(wxConfig);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxconfig:update")
    @ResponseBody
    public R update(@RequestBody WxConfigEntity wxConfig) {
        wxConfigService.update(wxConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxconfig:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxConfigService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxConfigEntity> list = wxConfigService.queryList(params);

        return R.ok().put("list", list);
    }
}
