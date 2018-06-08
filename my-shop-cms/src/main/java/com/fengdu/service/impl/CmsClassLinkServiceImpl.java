package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsClassLinkDao;
import com.fengdu.entity.CmsClassLinkEntity;
import com.fengdu.service.CmsClassLinkService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
@Service("cmsClassLinkService")
public class CmsClassLinkServiceImpl implements CmsClassLinkService {
    @Autowired
    private CmsClassLinkDao cmsClassLinkDao;

    @Override
    public CmsClassLinkEntity queryObject(String classid) {
        return cmsClassLinkDao.queryObject(classid);
    }

    @Override
    public List<CmsClassLinkEntity> queryList(Map<String, Object> map) {
        return cmsClassLinkDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsClassLinkDao.queryTotal(map);
    }

    @Override
    public int save(CmsClassLinkEntity cmsClassLink) {
        return cmsClassLinkDao.save(cmsClassLink);
    }

    @Override
    public int update(CmsClassLinkEntity cmsClassLink) {
        return cmsClassLinkDao.update(cmsClassLink);
    }

    @Override
    public int delete(String classid) {
        return cmsClassLinkDao.delete(classid);
    }

    @Override
    public int deleteBatch(String[]classids) {
        return cmsClassLinkDao.deleteBatch(classids);
    }
}
