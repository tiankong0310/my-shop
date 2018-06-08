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

import com.fengdu.entity.CmsLinkEntity;
import com.fengdu.service.CmsLinkService;
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
@RequestMapping("cmslink")
public class CmsLinkController {
    @Autowired
    private CmsLinkService cmsLinkService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmslink:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsLinkEntity> cmsLinkList = cmsLinkService.queryList(query);
        int total = cmsLinkService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsLinkList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmslink:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        CmsLinkEntity cmsLink = cmsLinkService.queryObject(id);

        return R.ok().put("cmsLink", cmsLink);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmslink:save")
    @ResponseBody
    public R save(@RequestBody CmsLinkEntity cmsLink) {
    	cmsLink.setId( IdUtil.createIdbyUUID());
        cmsLinkService.save(cmsLink);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmslink:update")
    @ResponseBody
    public R update(@RequestBody CmsLinkEntity cmsLink) {
        cmsLinkService.update(cmsLink);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmslink:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        cmsLinkService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsLinkEntity> list = cmsLinkService.queryList(params);

        return R.ok().put("list", list);
    }
}
