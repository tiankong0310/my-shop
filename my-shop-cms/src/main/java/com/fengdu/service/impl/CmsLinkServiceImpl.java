package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsLinkDao;
import com.fengdu.entity.CmsLinkEntity;
import com.fengdu.service.CmsLinkService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
@Service("cmsLinkService")
public class CmsLinkServiceImpl implements CmsLinkService {
    @Autowired
    private CmsLinkDao cmsLinkDao;

    @Override
    public CmsLinkEntity queryObject(String id) {
        return cmsLinkDao.queryObject(id);
    }

    @Override
    public List<CmsLinkEntity> queryList(Map<String, Object> map) {
        return cmsLinkDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsLinkDao.queryTotal(map);
    }

    @Override
    public int save(CmsLinkEntity cmsLink) {
        return cmsLinkDao.save(cmsLink);
    }

    @Override
    public int update(CmsLinkEntity cmsLink) {
        return cmsLinkDao.update(cmsLink);
    }

    @Override
    public int delete(String id) {
        return cmsLinkDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return cmsLinkDao.deleteBatch(ids);
    }
}
