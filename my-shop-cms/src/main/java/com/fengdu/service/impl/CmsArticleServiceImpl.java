package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsArticleDao;
import com.fengdu.entity.CmsArticleEntity;
import com.fengdu.service.CmsArticleService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:39
 */
@Service("cmsArticleService")
public class CmsArticleServiceImpl implements CmsArticleService {
    @Autowired
    private CmsArticleDao cmsArticleDao;

    @Override
    public CmsArticleEntity queryObject(String id) {
        return cmsArticleDao.queryObject(id);
    }

    @Override
    public List<CmsArticleEntity> queryList(Map<String, Object> map) {
        return cmsArticleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsArticleDao.queryTotal(map);
    }

    @Override
    public int save(CmsArticleEntity cmsArticle) {
        return cmsArticleDao.save(cmsArticle);
    }

    @Override
    public int update(CmsArticleEntity cmsArticle) {
        return cmsArticleDao.update(cmsArticle);
    }

    @Override
    public int delete(String id) {
        return cmsArticleDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return cmsArticleDao.deleteBatch(ids);
    }
}
