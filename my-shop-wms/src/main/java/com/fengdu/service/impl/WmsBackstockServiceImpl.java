package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsBackstockDao;
import com.fengdu.entity.WmsBackstockEntity;
import com.fengdu.service.WmsBackstockService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Service("wmsBackstockService")
public class WmsBackstockServiceImpl implements WmsBackstockService {
    @Autowired
    private WmsBackstockDao wmsBackstockDao;

    @Override
    public WmsBackstockEntity queryObject(String id) {
        return wmsBackstockDao.queryObject(id);
    }

    @Override
    public List<WmsBackstockEntity> queryList(Map<String, Object> map) {
        return wmsBackstockDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsBackstockDao.queryTotal(map);
    }

    @Override
    public int save(WmsBackstockEntity wmsBackstock) {
        return wmsBackstockDao.save(wmsBackstock);
    }

    @Override
    public int update(WmsBackstockEntity wmsBackstock) {
        return wmsBackstockDao.update(wmsBackstock);
    }

    @Override
    public int delete(String id) {
        return wmsBackstockDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsBackstockDao.deleteBatch(ids);
    }
}
