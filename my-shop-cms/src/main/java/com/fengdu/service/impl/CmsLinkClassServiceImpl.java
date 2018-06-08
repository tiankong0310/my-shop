package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsLinkClassDao;
import com.fengdu.entity.CmsLinkClassEntity;
import com.fengdu.service.CmsLinkClassService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
@Service("cmsLinkClassService")
public class CmsLinkClassServiceImpl implements CmsLinkClassService {
    @Autowired
    private CmsLinkClassDao cmsLinkClassDao;

    @Override
    public CmsLinkClassEntity queryObject(String id) {
        return cmsLinkClassDao.queryObject(id);
    }

    @Override
    public List<CmsLinkClassEntity> queryList(Map<String, Object> map) {
        return cmsLinkClassDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsLinkClassDao.queryTotal(map);
    }

    @Override
    public int save(CmsLinkClassEntity cmsLinkClass) {
        return cmsLinkClassDao.save(cmsLinkClass);
    }

    @Override
    public int update(CmsLinkClassEntity cmsLinkClass) {
        return cmsLinkClassDao.update(cmsLinkClass);
    }

    @Override
    public int delete(String id) {
        return cmsLinkClassDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return cmsLinkClassDao.deleteBatch(ids);
    }
}
