package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.CmsSiteDao;
import com.fengdu.entity.CmsSiteEntity;
import com.fengdu.service.CmsSiteService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("cmsSiteService")
public class CmsSiteServiceImpl implements CmsSiteService {
    @Autowired
    private CmsSiteDao cmsSiteDao;

    @Override
    public CmsSiteEntity queryObject(String id) {
        return cmsSiteDao.queryObject(id);
    }

    @Override
    public List<CmsSiteEntity> queryList(Map<String, Object> map) {
        return cmsSiteDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return cmsSiteDao.queryTotal(map);
    }

    @Override
    public int save(CmsSiteEntity cmsSite) {
        return cmsSiteDao.save(cmsSite);
    }

    @Override
    public int update(CmsSiteEntity cmsSite) {
        return cmsSiteDao.update(cmsSite);
    }

    @Override
    public int delete(String id) {
        return cmsSiteDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return cmsSiteDao.deleteBatch(ids);
    }
}
