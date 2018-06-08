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

import com.fengdu.entity.WmsEnterstockDetailEntity;
import com.fengdu.service.WmsEnterstockDetailService;
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
@RequestMapping("wmsenterstockdetail")
public class WmsEnterstockDetailController {
    @Autowired
    private WmsEnterstockDetailService wmsEnterstockDetailService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsenterstockdetail:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsEnterstockDetailEntity> wmsEnterstockDetailList = wmsEnterstockDetailService.queryList(query);
        int total = wmsEnterstockDetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsEnterstockDetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsenterstockdetail:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsEnterstockDetailEntity wmsEnterstockDetail = wmsEnterstockDetailService.queryObject(id);

        return R.ok().put("wmsEnterstockDetail", wmsEnterstockDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsenterstockdetail:save")
    @ResponseBody
    public R save(@RequestBody WmsEnterstockDetailEntity wmsEnterstockDetail) {
    	wmsEnterstockDetail.setId( IdUtil.createIdbyUUID());
        wmsEnterstockDetailService.save(wmsEnterstockDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsenterstockdetail:update")
    @ResponseBody
    public R update(@RequestBody WmsEnterstockDetailEntity wmsEnterstockDetail) {
        wmsEnterstockDetailService.update(wmsEnterstockDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsenterstockdetail:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsEnterstockDetailService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsEnterstockDetailEntity> list = wmsEnterstockDetailService.queryList(params);

        return R.ok().put("list", list);
    }
}
