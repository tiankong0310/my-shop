package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsLeavestockDao;
import com.fengdu.entity.WmsLeavestockEntity;
import com.fengdu.service.WmsLeavestockService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Service("wmsLeavestockService")
public class WmsLeavestockServiceImpl implements WmsLeavestockService {
    @Autowired
    private WmsLeavestockDao wmsLeavestockDao;

    @Override
    public WmsLeavestockEntity queryObject(String id) {
        return wmsLeavestockDao.queryObject(id);
    }

    @Override
    public List<WmsLeavestockEntity> queryList(Map<String, Object> map) {
        return wmsLeavestockDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsLeavestockDao.queryTotal(map);
    }

    @Override
    public int save(WmsLeavestockEntity wmsLeavestock) {
        return wmsLeavestockDao.save(wmsLeavestock);
    }

    @Override
    public int update(WmsLeavestockEntity wmsLeavestock) {
        return wmsLeavestockDao.update(wmsLeavestock);
    }

    @Override
    public int delete(String id) {
        return wmsLeavestockDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsLeavestockDao.deleteBatch(ids);
    }
}
