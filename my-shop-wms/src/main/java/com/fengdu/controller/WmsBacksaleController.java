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
import org.springframework.web.bind.annotation.RestController;

import com.fengdu.entity.WmsBacksaleEntity;
import com.fengdu.service.WmsBacksaleService;
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
@RequestMapping("wmsbacksale")
public class WmsBacksaleController {
    @Autowired
    private WmsBacksaleService wmsBacksaleService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wmsbacksale:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WmsBacksaleEntity> wmsBacksaleList = wmsBacksaleService.queryList(query);
        int total = wmsBacksaleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wmsBacksaleList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wmsbacksale:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WmsBacksaleEntity wmsBacksale = wmsBacksaleService.queryObject(id);

        return R.ok().put("wmsBacksale", wmsBacksale);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wmsbacksale:save")
    @ResponseBody
    public R save(@RequestBody WmsBacksaleEntity wmsBacksale) {
    	wmsBacksale.setId( IdUtil.createIdbyUUID());
        wmsBacksaleService.save(wmsBacksale);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wmsbacksale:update")
    @ResponseBody
    public R update(@RequestBody WmsBacksaleEntity wmsBacksale) {
        wmsBacksaleService.update(wmsBacksale);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wmsbacksale:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wmsBacksaleService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WmsBacksaleEntity> list = wmsBacksaleService.queryList(params);

        return R.ok().put("list", list);
    }
}
