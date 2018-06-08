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

import com.fengdu.entity.WxMassEntity;
import com.fengdu.service.WxMassService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:38
 */
@Controller
@RequestMapping("wxmass")
public class WxMassController {
    @Autowired
    private WxMassService wxMassService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxmass:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxMassEntity> wxMassList = wxMassService.queryList(query);
        int total = wxMassService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxMassList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxmass:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxMassEntity wxMass = wxMassService.queryObject(id);

        return R.ok().put("wxMass", wxMass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxmass:save")
    @ResponseBody
    public R save(@RequestBody WxMassEntity wxMass) {
      
        wxMass.setId( IdUtil.createIdbyUUID());
        wxMassService.save(wxMass);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxmass:update")
    @ResponseBody
    public R update(@RequestBody WxMassEntity wxMass) {
        wxMassService.update(wxMass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxmass:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxMassService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxMassEntity> list = wxMassService.queryList(params);

        return R.ok().put("list", list);
    }
}
