package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMassNewsDao;
import com.fengdu.entity.WxMassNewsEntity;
import com.fengdu.service.WxMassNewsService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxMassNewsService")
public class WxMassNewsServiceImpl implements WxMassNewsService {
    @Autowired
    private WxMassNewsDao wxMassNewsDao;

    @Override
    public WxMassNewsEntity queryObject(String id) {
        return wxMassNewsDao.queryObject(id);
    }

    @Override
    public List<WxMassNewsEntity> queryList(Map<String, Object> map) {
        return wxMassNewsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMassNewsDao.queryTotal(map);
    }

    @Override
    public int save(WxMassNewsEntity wxMassNews) {
        return wxMassNewsDao.save(wxMassNews);
    }

    @Override
    public int update(WxMassNewsEntity wxMassNews) {
        return wxMassNewsDao.update(wxMassNews);
    }

    @Override
    public int delete(String id) {
        return wxMassNewsDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMassNewsDao.deleteBatch(ids);
    }
}
