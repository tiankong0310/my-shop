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

import com.fengdu.entity.WmsBackstockEntity;
import com.fengdu.service.WmsBackstockService;
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
@RequestMapping("wmsbackstock")
public class WmsBackstockController {
    @Autowired
    private WmsBackstockService wmsBackstockService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsbackstock:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsBackstockEntity> wmsBackstockList = wmsBackstockService.queryList(query);
        int total = wmsBackstockService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsBackstockList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsbackstock:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsBackstockEntity wmsBackstock = wmsBackstockService.queryObject(id);

        return R.ok().put("wmsBackstock", wmsBackstock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsbackstock:save")
    @ResponseBody
    public R save(@RequestBody WmsBackstockEntity wmsBackstock) {
    	wmsBackstock.setId( IdUtil.createIdbyUUID());
        wmsBackstockService.save(wmsBackstock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsbackstock:update")
    @ResponseBody
    public R update(@RequestBody WmsBackstockEntity wmsBackstock) {
        wmsBackstockService.update(wmsBackstock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsbackstock:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsBackstockService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsBackstockEntity> list = wmsBackstockService.queryList(params);

        return R.ok().put("list", list);
    }
}
