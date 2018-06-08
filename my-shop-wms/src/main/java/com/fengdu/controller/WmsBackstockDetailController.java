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

import com.fengdu.entity.WmsBackstockDetailEntity;
import com.fengdu.service.WmsBackstockDetailService;
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
@RequestMapping("wmsbackstockdetail")
public class WmsBackstockDetailController {
    @Autowired
    private WmsBackstockDetailService wmsBackstockDetailService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsbackstockdetail:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsBackstockDetailEntity> wmsBackstockDetailList = wmsBackstockDetailService.queryList(query);
        int total = wmsBackstockDetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsBackstockDetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsbackstockdetail:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsBackstockDetailEntity wmsBackstockDetail = wmsBackstockDetailService.queryObject(id);

        return R.ok().put("wmsBackstockDetail", wmsBackstockDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsbackstockdetail:save")
    @ResponseBody
    public R save(@RequestBody WmsBackstockDetailEntity wmsBackstockDetail) {
    	wmsBackstockDetail.setId( IdUtil.createIdbyUUID());
        wmsBackstockDetailService.save(wmsBackstockDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsbackstockdetail:update")
    @ResponseBody
    public R update(@RequestBody WmsBackstockDetailEntity wmsBackstockDetail) {
        wmsBackstockDetailService.update(wmsBackstockDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsbackstockdetail:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsBackstockDetailService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsBackstockDetailEntity> list = wmsBackstockDetailService.queryList(params);

        return R.ok().put("list", list);
    }
}
