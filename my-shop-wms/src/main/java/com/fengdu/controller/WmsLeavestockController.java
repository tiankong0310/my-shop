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

import com.fengdu.entity.WmsLeavestockEntity;
import com.fengdu.service.WmsLeavestockService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Controller
@RequestMapping("wmsleavestock")
public class WmsLeavestockController {
    @Autowired
    private WmsLeavestockService wmsLeavestockService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsleavestock:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsLeavestockEntity> wmsLeavestockList = wmsLeavestockService.queryList(query);
        int total = wmsLeavestockService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsLeavestockList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsleavestock:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsLeavestockEntity wmsLeavestock = wmsLeavestockService.queryObject(id);

        return R.ok().put("wmsLeavestock", wmsLeavestock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsleavestock:save")
    @ResponseBody
    public R save(@RequestBody WmsLeavestockEntity wmsLeavestock) {
    	wmsLeavestock.setId( IdUtil.createIdbyUUID());
        wmsLeavestockService.save(wmsLeavestock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsleavestock:update")
    @ResponseBody
    public R update(@RequestBody WmsLeavestockEntity wmsLeavestock) {
        wmsLeavestockService.update(wmsLeavestock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsleavestock:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsLeavestockService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsLeavestockEntity> list = wmsLeavestockService.queryList(params);

        return R.ok().put("list", list);
    }
}
