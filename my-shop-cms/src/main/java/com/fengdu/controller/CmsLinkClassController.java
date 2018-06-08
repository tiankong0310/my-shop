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

import com.fengdu.entity.CmsLinkClassEntity;
import com.fengdu.service.CmsLinkClassService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:39
 */
@Controller
@RequestMapping("cmslinkclass")
public class CmsLinkClassController {
    @Autowired
    private CmsLinkClassService cmsLinkClassService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmslinkclass:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsLinkClassEntity> cmsLinkClassList = cmsLinkClassService.queryList(query);
        int total = cmsLinkClassService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsLinkClassList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmslinkclass:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        CmsLinkClassEntity cmsLinkClass = cmsLinkClassService.queryObject(id);

        return R.ok().put("cmsLinkClass", cmsLinkClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmslinkclass:save")
    @ResponseBody
    public R save(@RequestBody CmsLinkClassEntity cmsLinkClass) {
    	cmsLinkClass.setId( IdUtil.createIdbyUUID());
        cmsLinkClassService.save(cmsLinkClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmslinkclass:update")
    @ResponseBody
    public R update(@RequestBody CmsLinkClassEntity cmsLinkClass) {
        cmsLinkClassService.update(cmsLinkClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmslinkclass:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        cmsLinkClassService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsLinkClassEntity> list = cmsLinkClassService.queryList(params);

        return R.ok().put("list", list);
    }
}
