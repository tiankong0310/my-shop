package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsLeavestockDetailDao;
import com.fengdu.entity.WmsLeavestockDetailEntity;
import com.fengdu.service.WmsLeavestockDetailService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Service("wmsLeavestockDetailService")
public class WmsLeavestockDetailServiceImpl implements WmsLeavestockDetailService {
    @Autowired
    private WmsLeavestockDetailDao wmsLeavestockDetailDao;

    @Override
    public WmsLeavestockDetailEntity queryObject(String id) {
        return wmsLeavestockDetailDao.queryObject(id);
    }

    @Override
    public List<WmsLeavestockDetailEntity> queryList(Map<String, Object> map) {
        return wmsLeavestockDetailDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsLeavestockDetailDao.queryTotal(map);
    }

    @Override
    public int save(WmsLeavestockDetailEntity wmsLeavestockDetail) {
        return wmsLeavestockDetailDao.save(wmsLeavestockDetail);
    }

    @Override
    public int update(WmsLeavestockDetailEntity wmsLeavestockDetail) {
        return wmsLeavestockDetailDao.update(wmsLeavestockDetail);
    }

    @Override
    public int delete(String id) {
        return wmsLeavestockDetailDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsLeavestockDetailDao.deleteBatch(ids);
    }
}
