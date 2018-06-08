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

import com.fengdu.entity.WxTplLogEntity;
import com.fengdu.service.WxTplLogService;
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
@RequestMapping("wxtpllog")
public class WxTplLogController {
    @Autowired
    private WxTplLogService wxTplLogService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxtpllog:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxTplLogEntity> wxTplLogList = wxTplLogService.queryList(query);
        int total = wxTplLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxTplLogList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxtpllog:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxTplLogEntity wxTplLog = wxTplLogService.queryObject(id);

        return R.ok().put("wxTplLog", wxTplLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxtpllog:save")
    @ResponseBody
    public R save(@RequestBody WxTplLogEntity wxTplLog) {
    	wxTplLog.setId( IdUtil.createIdbyUUID());
        wxTplLogService.save(wxTplLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxtpllog:update")
    @ResponseBody
    public R update(@RequestBody WxTplLogEntity wxTplLog) {
        wxTplLogService.update(wxTplLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxtpllog:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxTplLogService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxTplLogEntity> list = wxTplLogService.queryList(params);

        return R.ok().put("list", list);
    }
}
