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

import com.fengdu.entity.WxTplListEntity;
import com.fengdu.service.WxTplListService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:37
 */
@Controller
@RequestMapping("wxtpllist")
public class WxTplListController {
    @Autowired
    private WxTplListService wxTplListService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxtpllist:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxTplListEntity> wxTplListList = wxTplListService.queryList(query);
        int total = wxTplListService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxTplListList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxtpllist:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxTplListEntity wxTplList = wxTplListService.queryObject(id);

        return R.ok().put("wxTplList", wxTplList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxtpllist:save")
    @ResponseBody
    public R save(@RequestBody WxTplListEntity wxTplList) {
    	
    	wxTplList.setId( IdUtil.createIdbyUUID());
        wxTplListService.save(wxTplList);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxtpllist:update")
    @ResponseBody
    public R update(@RequestBody WxTplListEntity wxTplList) {
        wxTplListService.update(wxTplList);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxtpllist:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxTplListService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxTplListEntity> list = wxTplListService.queryList(params);

        return R.ok().put("list", list);
    }
}
