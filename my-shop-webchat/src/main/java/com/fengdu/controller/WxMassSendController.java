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

import com.fengdu.entity.WxMassSendEntity;
import com.fengdu.service.WxMassSendService;
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
@RequestMapping("wxmasssend")
public class WxMassSendController {
    @Autowired
    private WxMassSendService wxMassSendService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxmasssend:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxMassSendEntity> wxMassSendList = wxMassSendService.queryList(query);
        int total = wxMassSendService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxMassSendList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxmasssend:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxMassSendEntity wxMassSend = wxMassSendService.queryObject(id);

        return R.ok().put("wxMassSend", wxMassSend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxmasssend:save")
    @ResponseBody
    public R save(@RequestBody WxMassSendEntity wxMassSend) {
    	wxMassSend.setId( IdUtil.createIdbyUUID());
        wxMassSendService.save(wxMassSend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxmasssend:update")
    @ResponseBody
    public R update(@RequestBody WxMassSendEntity wxMassSend) {
        wxMassSendService.update(wxMassSend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxmasssend:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxMassSendService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxMassSendEntity> list = wxMassSendService.queryList(params);

        return R.ok().put("list", list);
    }
}
