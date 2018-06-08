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

import com.fengdu.entity.CmsClassLinkEntity;
import com.fengdu.service.CmsClassLinkService;
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
@RequestMapping("cmsclasslink")
public class CmsClassLinkController {
    @Autowired
    private CmsClassLinkService cmsClassLinkService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmsclasslink:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsClassLinkEntity> cmsClassLinkList = cmsClassLinkService.queryList(query);
        int total = cmsClassLinkService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsClassLinkList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{classid}")
    @RequiresPermissions("cmsclasslink:info")
    @ResponseBody
    public R info(@PathVariable("classid") String classid) {
        CmsClassLinkEntity cmsClassLink = cmsClassLinkService.queryObject(classid);

        return R.ok().put("cmsClassLink", cmsClassLink);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmsclasslink:save")
    @ResponseBody
    public R save(@RequestBody CmsClassLinkEntity cmsClassLink) {
        cmsClassLinkService.save(cmsClassLink);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmsclasslink:update")
    @ResponseBody
    public R update(@RequestBody CmsClassLinkEntity cmsClassLink) {
        cmsClassLinkService.update(cmsClassLink);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmsclasslink:delete")
    @ResponseBody
    public R delete(@RequestBody String[]classids) {
        cmsClassLinkService.deleteBatch(classids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsClassLinkEntity> list = cmsClassLinkService.queryList(params);

        return R.ok().put("list", list);
    }
}
