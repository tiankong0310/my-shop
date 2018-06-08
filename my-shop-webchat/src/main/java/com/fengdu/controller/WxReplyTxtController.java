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

import com.fengdu.entity.WxReplyTxtEntity;
import com.fengdu.service.WxReplyTxtService;
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
@RequestMapping("wxreplytxt")
public class WxReplyTxtController {
    @Autowired
    private WxReplyTxtService wxReplyTxtService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxreplytxt:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxReplyTxtEntity> wxReplyTxtList = wxReplyTxtService.queryList(query);
        int total = wxReplyTxtService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxReplyTxtList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxreplytxt:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxReplyTxtEntity wxReplyTxt = wxReplyTxtService.queryObject(id);

        return R.ok().put("wxReplyTxt", wxReplyTxt);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxreplytxt:save")
    @ResponseBody
    public R save(@RequestBody WxReplyTxtEntity wxReplyTxt) {
    	
    	wxReplyTxt.setId( IdUtil.createIdbyUUID());
        wxReplyTxtService.save(wxReplyTxt);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxreplytxt:update")
    @ResponseBody
    public R update(@RequestBody WxReplyTxtEntity wxReplyTxt) {
        wxReplyTxtService.update(wxReplyTxt);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxreplytxt:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxReplyTxtService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxReplyTxtEntity> list = wxReplyTxtService.queryList(params);

        return R.ok().put("list", list);
    }
}
