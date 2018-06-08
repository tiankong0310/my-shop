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

import com.fengdu.entity.WxMassNewsEntity;
import com.fengdu.service.WxMassNewsService;
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
@RequestMapping("wxmassnews")
public class WxMassNewsController {
    @Autowired
    private WxMassNewsService wxMassNewsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("wxmassnews:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WxMassNewsEntity> wxMassNewsList = wxMassNewsService.queryList(query);
        int total = wxMassNewsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(wxMassNewsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("wxmassnews:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        WxMassNewsEntity wxMassNews = wxMassNewsService.queryObject(id);

        return R.ok().put("wxMassNews", wxMassNews);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("wxmassnews:save")
    @ResponseBody
    public R save(@RequestBody WxMassNewsEntity wxMassNews) {
    	wxMassNews.setId( IdUtil.createIdbyUUID());
        wxMassNewsService.save(wxMassNews);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("wxmassnews:update")
    @ResponseBody
    public R update(@RequestBody WxMassNewsEntity wxMassNews) {
        wxMassNewsService.update(wxMassNews);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("wxmassnews:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        wxMassNewsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<WxMassNewsEntity> list = wxMassNewsService.queryList(params);

        return R.ok().put("list", list);
    }
}
