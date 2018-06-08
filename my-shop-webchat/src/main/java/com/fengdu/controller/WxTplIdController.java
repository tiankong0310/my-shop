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

import com.fengdu.entity.WxTplIdEntity;
import com.fengdu.service.WxTplIdService;
import com.fengdu.utils.IdUtil;
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
@RequestMapping("wxtplid")
public class WxTplIdController {
    @Autowired
    private WxTplIdService wxTplIdService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxtplid:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxTplIdEntity> wxTplIdList = wxTplIdService.queryList(query);
        int total = wxTplIdService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxTplIdList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxtplid:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxTplIdEntity wxTplId = wxTplIdService.queryObject(id);

        return R.ok().put("wxTplId", wxTplId);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxtplid:save")
    @ResponseBody
    public R save(@RequestBody WxTplIdEntity wxTplId) {
    	
    	wxTplId.setId( IdUtil.createIdbyUUID());
        wxTplIdService.save(wxTplId);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxtplid:update")
    @ResponseBody
    public R update(@RequestBody WxTplIdEntity wxTplId) {
        wxTplIdService.update(wxTplId);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxtplid:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxTplIdService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxTplIdEntity> list = wxTplIdService.queryList(params);

        return R.ok().put("list", list);
    }
}
