package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsEnterstockDetailDao;
import com.fengdu.entity.WmsEnterstockDetailEntity;
import com.fengdu.service.WmsEnterstockDetailService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Service("wmsEnterstockDetailService")
public class WmsEnterstockDetailServiceImpl implements WmsEnterstockDetailService {
    @Autowired
    private WmsEnterstockDetailDao wmsEnterstockDetailDao;

    @Override
    public WmsEnterstockDetailEntity queryObject(String id) {
        return wmsEnterstockDetailDao.queryObject(id);
    }

    @Override
    public List<WmsEnterstockDetailEntity> queryList(Map<String, Object> map) {
        return wmsEnterstockDetailDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsEnterstockDetailDao.queryTotal(map);
    }

    @Override
    public int save(WmsEnterstockDetailEntity wmsEnterstockDetail) {
        return wmsEnterstockDetailDao.save(wmsEnterstockDetail);
    }

    @Override
    public int update(WmsEnterstockDetailEntity wmsEnterstockDetail) {
        return wmsEnterstockDetailDao.update(wmsEnterstockDetail);
    }

    @Override
    public int delete(String id) {
        return wmsEnterstockDetailDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsEnterstockDetailDao.deleteBatch(ids);
    }
}
