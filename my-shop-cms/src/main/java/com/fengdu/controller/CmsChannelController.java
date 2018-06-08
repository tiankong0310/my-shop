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

import com.fengdu.entity.CmsChannelEntity;
import com.fengdu.service.CmsChannelService;
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
@RequestMapping("cmschannel")
public class CmsChannelController {
    @Autowired
    private CmsChannelService cmsChannelService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmschannel:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsChannelEntity> cmsChannelList = cmsChannelService.queryList(query);
        int total = cmsChannelService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsChannelList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmschannel:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        CmsChannelEntity cmsChannel = cmsChannelService.queryObject(id);

        return R.ok().put("cmsChannel", cmsChannel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmschannel:save")
    @ResponseBody
    public R save(@RequestBody CmsChannelEntity cmsChannel) {
    	cmsChannel.setId( IdUtil.createIdbyUUID());
        cmsChannelService.save(cmsChannel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmschannel:update")
    @ResponseBody
    public R update(@RequestBody CmsChannelEntity cmsChannel) {
        cmsChannelService.update(cmsChannel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmschannel:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        cmsChannelService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsChannelEntity> list = cmsChannelService.queryList(params);

        return R.ok().put("list", list);
    }
}
