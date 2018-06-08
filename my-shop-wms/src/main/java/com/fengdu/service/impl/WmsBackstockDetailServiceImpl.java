package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsBackstockDetailDao;
import com.fengdu.entity.WmsBackstockDetailEntity;
import com.fengdu.service.WmsBackstockDetailService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Service("wmsBackstockDetailService")
public class WmsBackstockDetailServiceImpl implements WmsBackstockDetailService {
    @Autowired
    private WmsBackstockDetailDao wmsBackstockDetailDao;

    @Override
    public WmsBackstockDetailEntity queryObject(String id) {
        return wmsBackstockDetailDao.queryObject(id);
    }

    @Override
    public List<WmsBackstockDetailEntity> queryList(Map<String, Object> map) {
        return wmsBackstockDetailDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsBackstockDetailDao.queryTotal(map);
    }

    @Override
    public int save(WmsBackstockDetailEntity wmsBackstockDetail) {
        return wmsBackstockDetailDao.save(wmsBackstockDetail);
    }

    @Override
    public int update(WmsBackstockDetailEntity wmsBackstockDetail) {
        return wmsBackstockDetailDao.update(wmsBackstockDetail);
    }

    @Override
    public int delete(String id) {
        return wmsBackstockDetailDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsBackstockDetailDao.deleteBatch(ids);
    }
}
