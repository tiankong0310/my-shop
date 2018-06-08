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

import com.fengdu.entity.WxMsgReplyEntity;
import com.fengdu.service.WxMsgReplyService;
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
@RequestMapping("wxmsgreply")
public class WxMsgReplyController {
    @Autowired
    private WxMsgReplyService wxMsgReplyService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxmsgreply:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxMsgReplyEntity> wxMsgReplyList = wxMsgReplyService.queryList(query);
        int total = wxMsgReplyService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxMsgReplyList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxmsgreply:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxMsgReplyEntity wxMsgReply = wxMsgReplyService.queryObject(id);

        return R.ok().put("wxMsgReply", wxMsgReply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxmsgreply:save")
    @ResponseBody
    public R save(@RequestBody WxMsgReplyEntity wxMsgReply) {
    	wxMsgReply.setId( IdUtil.createIdbyUUID());
        wxMsgReplyService.save(wxMsgReply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxmsgreply:update")
    @ResponseBody
    public R update(@RequestBody WxMsgReplyEntity wxMsgReply) {
        wxMsgReplyService.update(wxMsgReply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxmsgreply:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxMsgReplyService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxMsgReplyEntity> list = wxMsgReplyService.queryList(params);

        return R.ok().put("list", list);
    }
}
