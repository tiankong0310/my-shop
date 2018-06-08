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

import com.fengdu.entity.WmsStockpileEntity;
import com.fengdu.service.WmsStockpileService;
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
@RequestMapping("wmsstockpile")
public class WmsStockpileController {
    @Autowired
    private WmsStockpileService wmsStockpileService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsstockpile:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsStockpileEntity> wmsStockpileList = wmsStockpileService.queryList(query);
        int total = wmsStockpileService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsStockpileList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsstockpile:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsStockpileEntity wmsStockpile = wmsStockpileService.queryObject(id);

        return R.ok().put("wmsStockpile", wmsStockpile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsstockpile:save")
    @ResponseBody
    public R save(@RequestBody WmsStockpileEntity wmsStockpile) {
    	wmsStockpile.setId( IdUtil.createIdbyUUID());
        wmsStockpileService.save(wmsStockpile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsstockpile:update")
    @ResponseBody
    public R update(@RequestBody WmsStockpileEntity wmsStockpile) {
        wmsStockpileService.update(wmsStockpile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsstockpile:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsStockpileService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsStockpileEntity> list = wmsStockpileService.queryList(params);

        return R.ok().put("list", list);
    }
}
