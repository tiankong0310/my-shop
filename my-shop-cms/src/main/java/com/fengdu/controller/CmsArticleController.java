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

import com.fengdu.entity.CmsArticleEntity;
import com.fengdu.service.CmsArticleService;
import com.fengdu.utils.IdUtil;
import com.fengdu.utils.PageUtils;
import com.fengdu.utils.Query;
import com.fengdu.utils.R;

/**
 * Controller
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:39
 */
@Controller
@RequestMapping("cmsarticle")
public class CmsArticleController {
    @Autowired
    private CmsArticleService cmsArticleService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmsarticle:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CmsArticleEntity> cmsArticleList = cmsArticleService.queryList(query);
        int total = cmsArticleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(cmsArticleList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmsarticle:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        CmsArticleEntity cmsArticle = cmsArticleService.queryObject(id);

        return R.ok().put("cmsArticle", cmsArticle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmsarticle:save")
    @ResponseBody
    public R save(@RequestBody CmsArticleEntity cmsArticle) {
    	
    	cmsArticle.setId( IdUtil.createIdbyUUID());
        cmsArticleService.save(cmsArticle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmsarticle:update")
    @ResponseBody
    public R update(@RequestBody CmsArticleEntity cmsArticle) {
        cmsArticleService.update(cmsArticle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmsarticle:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        cmsArticleService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsArticleEntity> list = cmsArticleService.queryList(params);

        return R.ok().put("list", list);
    }
}
