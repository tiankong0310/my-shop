package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsChannelDao;
import com.fengdu.entity.CmsChannelEntity;
import com.fengdu.service.CmsChannelService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 15:56:39
 */
@Service("cmsChannelService")
public class CmsChannelServiceImpl implements CmsChannelService {
    @Autowired
    private CmsChannelDao cmsChannelDao;

    @Override
    public CmsChannelEntity queryObject(String id) {
        return cmsChannelDao.queryObject(id);
    }

    @Override
    public List<CmsChannelEntity> queryList(Map<String, Object> map) {
        return cmsChannelDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsChannelDao.queryTotal(map);
    }

    @Override
    public int save(CmsChannelEntity cmsChannel) {
        return cmsChannelDao.save(cmsChannel);
    }

    @Override
    public int update(CmsChannelEntity cmsChannel) {
        return cmsChannelDao.update(cmsChannel);
    }

    @Override
    public int delete(String id) {
        return cmsChannelDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return cmsChannelDao.deleteBatch(ids);
    }
}
