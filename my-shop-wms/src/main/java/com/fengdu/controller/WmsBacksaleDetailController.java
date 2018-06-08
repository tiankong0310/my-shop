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

import com.fengdu.entity.WmsBacksaleDetailEntity;
import com.fengdu.service.WmsBacksaleDetailService;
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
@RequestMapping("wmsbacksaledetail")
public class WmsBacksaleDetailController {
    @Autowired
    private WmsBacksaleDetailService wmsBacksaleDetailService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsbacksaledetail:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsBacksaleDetailEntity> wmsBacksaleDetailList = wmsBacksaleDetailService.queryList(query);
        int total = wmsBacksaleDetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsBacksaleDetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsbacksaledetail:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsBacksaleDetailEntity wmsBacksaleDetail = wmsBacksaleDetailService.queryObject(id);

        return R.ok().put("wmsBacksaleDetail", wmsBacksaleDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsbacksaledetail:save")
    @ResponseBody
    public R save(@RequestBody WmsBacksaleDetailEntity wmsBacksaleDetail) {
    	wmsBacksaleDetail.setId( IdUtil.createIdbyUUID());
        wmsBacksaleDetailService.save(wmsBacksaleDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsbacksaledetail:update")
    @ResponseBody
    public R update(@RequestBody WmsBacksaleDetailEntity wmsBacksaleDetail) {
        wmsBacksaleDetailService.update(wmsBacksaleDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsbacksaledetail:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsBacksaleDetailService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsBacksaleDetailEntity> list = wmsBacksaleDetailService.queryList(params);

        return R.ok().put("list", list);
    }
}
