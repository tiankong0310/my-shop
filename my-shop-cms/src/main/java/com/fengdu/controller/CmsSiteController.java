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

import com.fengdu.entity.CmsSiteEntity;
import com.fengdu.service.CmsSiteService;
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
@RequestMapping("cmssite")
public class CmsSiteController {
    @Autowired
    private CmsSiteService cmsSiteService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmssite:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsSiteEntity> cmsSiteList = cmsSiteService.queryList(query);
        int total = cmsSiteService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsSiteList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmssite:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        CmsSiteEntity cmsSite = cmsSiteService.queryObject(id);

        return R.ok().put("cmsSite", cmsSite);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmssite:save")
    @ResponseBody
    public R save(@RequestBody CmsSiteEntity cmsSite) {
    	cmsSite.setId( IdUtil.createIdbyUUID());
        cmsSiteService.save(cmsSite);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmssite:update")
    @ResponseBody
    public R update(@RequestBody CmsSiteEntity cmsSite) {
        cmsSiteService.update(cmsSite);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmssite:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        cmsSiteService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsSiteEntity> list = cmsSiteService.queryList(params);

        return R.ok().put("list", list);
    }
}
