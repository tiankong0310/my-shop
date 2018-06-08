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

import com.fengdu.entity.WxReplyEntity;
import com.fengdu.service.WxReplyService;
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
@RequestMapping("wxreply")
public class WxReplyController {
    @Autowired
    private WxReplyService wxReplyService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxreply:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxReplyEntity> wxReplyList = wxReplyService.queryList(query);
        int total = wxReplyService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxReplyList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxreply:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxReplyEntity wxReply = wxReplyService.queryObject(id);

        return R.ok().put("wxReply", wxReply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxreply:save")
    @ResponseBody
    public R save(@RequestBody WxReplyEntity wxReply) {
    	wxReply.setId( IdUtil.createIdbyUUID());
        wxReplyService.save(wxReply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxreply:update")
    @ResponseBody
    public R update(@RequestBody WxReplyEntity wxReply) {
        wxReplyService.update(wxReply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxreply:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxReplyService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxReplyEntity> list = wxReplyService.queryList(params);

        return R.ok().put("list", list);
    }
}
