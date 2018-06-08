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

import com.fengdu.entity.WmsLeavestockDetailEntity;
import com.fengdu.service.WmsLeavestockDetailService;
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
@RequestMapping("wmsleavestockdetail")
public class WmsLeavestockDetailController {
    @Autowired
    private WmsLeavestockDetailService wmsLeavestockDetailService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsleavestockdetail:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsLeavestockDetailEntity> wmsLeavestockDetailList = wmsLeavestockDetailService.queryList(query);
        int total = wmsLeavestockDetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsLeavestockDetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsleavestockdetail:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsLeavestockDetailEntity wmsLeavestockDetail = wmsLeavestockDetailService.queryObject(id);

        return R.ok().put("wmsLeavestockDetail", wmsLeavestockDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsleavestockdetail:save")
    @ResponseBody
    public R save(@RequestBody WmsLeavestockDetailEntity wmsLeavestockDetail) {
    	wmsLeavestockDetail.setId( IdUtil.createIdbyUUID());
        wmsLeavestockDetailService.save(wmsLeavestockDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsleavestockdetail:update")
    @ResponseBody
    public R update(@RequestBody WmsLeavestockDetailEntity wmsLeavestockDetail) {
        wmsLeavestockDetailService.update(wmsLeavestockDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsleavestockdetail:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsLeavestockDetailService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsLeavestockDetailEntity> list = wmsLeavestockDetailService.queryList(params);

        return R.ok().put("list", list);
    }
}
