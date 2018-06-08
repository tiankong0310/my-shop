package com.fengdu.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengdu.entity.WxUserEntity;
import com.fengdu.service.WxUserService;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:37
 */
@Controller
@RequestMapping("wxuser")
public class WxUserController {
    @Autowired
    private WxUserService wxUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxuser:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxUserEntity> wxUserList = wxUserService.queryList(query);
        int total = wxUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxUserList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxuser:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxUserEntity wxUser = wxUserService.queryObject(id);

        return R.ok().put("wxUser", wxUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxuser:save")
    @ResponseBody
    public R save(@RequestBody WxUserEntity wxUser) {
    	wxUser.setId(String.valueOf(UUID.randomUUID()));
        wxUserService.save(wxUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxuser:update")
    @ResponseBody
    public R update(@RequestBody WxUserEntity wxUser) {
        wxUserService.update(wxUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxuser:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxUserService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxUserEntity> list = wxUserService.queryList(params);

        return R.ok().put("list", list);
    }
}
