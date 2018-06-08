package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsStockpileDao;
import com.fengdu.entity.WmsStockpileEntity;
import com.fengdu.service.WmsStockpileService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Service("wmsStockpileService")
public class WmsStockpileServiceImpl implements WmsStockpileService {
    @Autowired
    private WmsStockpileDao wmsStockpileDao;

    @Override
    public WmsStockpileEntity queryObject(String id) {
        return wmsStockpileDao.queryObject(id);
    }

    @Override
    public List<WmsStockpileEntity> queryList(Map<String, Object> map) {
        return wmsStockpileDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsStockpileDao.queryTotal(map);
    }

    @Override
    public int save(WmsStockpileEntity wmsStockpile) {
        return wmsStockpileDao.save(wmsStockpile);
    }

    @Override
    public int update(WmsStockpileEntity wmsStockpile) {
        return wmsStockpileDao.update(wmsStockpile);
    }

    @Override
    public int delete(String id) {
        return wmsStockpileDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsStockpileDao.deleteBatch(ids);
    }
}
