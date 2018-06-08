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

import com.fengdu.entity.WmsStorehouseEntity;
import com.fengdu.service.WmsStorehouseService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Controller
@RequestMapping("wmsstorehouse")
public class WmsStorehouseController {
    @Autowired
    private WmsStorehouseService wmsStorehouseService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsstorehouse:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsStorehouseEntity> wmsStorehouseList = wmsStorehouseService.queryList(query);
        int total = wmsStorehouseService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsStorehouseList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsstorehouse:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsStorehouseEntity wmsStorehouse = wmsStorehouseService.queryObject(id);

        return R.ok().put("wmsStorehouse", wmsStorehouse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsstorehouse:save")
    @ResponseBody
    public R save(@RequestBody WmsStorehouseEntity wmsStorehouse) {
    	wmsStorehouse.setId( IdUtil.createIdbyUUID());
        wmsStorehouseService.save(wmsStorehouse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsstorehouse:update")
    @ResponseBody
    public R update(@RequestBody WmsStorehouseEntity wmsStorehouse) {
        wmsStorehouseService.update(wmsStorehouse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsstorehouse:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsStorehouseService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsStorehouseEntity> list = wmsStorehouseService.queryList(params);

        return R.ok().put("list", list);
    }
}
