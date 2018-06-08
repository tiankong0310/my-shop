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

import com.fengdu.entity.WmsEnterstockEntity;
import com.fengdu.service.WmsEnterstockService;
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
@RequestMapping("wmsenterstock")
public class WmsEnterstockController {
    @Autowired
    private WmsEnterstockService wmsEnterstockService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsenterstock:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsEnterstockEntity> wmsEnterstockList = wmsEnterstockService.queryList(query);
        int total = wmsEnterstockService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsEnterstockList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsenterstock:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsEnterstockEntity wmsEnterstock = wmsEnterstockService.queryObject(id);

        return R.ok().put("wmsEnterstock", wmsEnterstock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsenterstock:save")
    @ResponseBody
    public R save(@RequestBody WmsEnterstockEntity wmsEnterstock) {
    	wmsEnterstock.setId( IdUtil.createIdbyUUID());
        wmsEnterstockService.save(wmsEnterstock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsenterstock:update")
    @ResponseBody
    public R update(@RequestBody WmsEnterstockEntity wmsEnterstock) {
        wmsEnterstockService.update(wmsEnterstock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsenterstock:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsEnterstockService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsEnterstockEntity> list = wmsEnterstockService.queryList(params);

        return R.ok().put("list", list);
    }
}
