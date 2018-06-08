package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsStorehouseDao;
import com.fengdu.entity.WmsStorehouseEntity;
import com.fengdu.service.WmsStorehouseService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Service("wmsStorehouseService")
public class WmsStorehouseServiceImpl implements WmsStorehouseService {
    @Autowired
    private WmsStorehouseDao wmsStorehouseDao;

    @Override
    public WmsStorehouseEntity queryObject(String id) {
        return wmsStorehouseDao.queryObject(id);
    }

    @Override
    public List<WmsStorehouseEntity> queryList(Map<String, Object> map) {
        return wmsStorehouseDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsStorehouseDao.queryTotal(map);
    }

    @Override
    public int save(WmsStorehouseEntity wmsStorehouse) {
        return wmsStorehouseDao.save(wmsStorehouse);
    }

    @Override
    public int update(WmsStorehouseEntity wmsStorehouse) {
        return wmsStorehouseDao.update(wmsStorehouse);
    }

    @Override
    public int delete(String id) {
        return wmsStorehouseDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsStorehouseDao.deleteBatch(ids);
    }
}
