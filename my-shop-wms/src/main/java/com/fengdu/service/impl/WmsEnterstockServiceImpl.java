package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsEnterstockDao;
import com.fengdu.entity.WmsEnterstockEntity;
import com.fengdu.service.WmsEnterstockService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:34
 */
@Service("wmsEnterstockService")
public class WmsEnterstockServiceImpl implements WmsEnterstockService {
    @Autowired
    private WmsEnterstockDao wmsEnterstockDao;

    @Override
    public WmsEnterstockEntity queryObject(String id) {
        return wmsEnterstockDao.queryObject(id);
    }

    @Override
    public List<WmsEnterstockEntity> queryList(Map<String, Object> map) {
        return wmsEnterstockDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsEnterstockDao.queryTotal(map);
    }

    @Override
    public int save(WmsEnterstockEntity wmsEnterstock) {
        return wmsEnterstockDao.save(wmsEnterstock);
    }

    @Override
    public int update(WmsEnterstockEntity wmsEnterstock) {
        return wmsEnterstockDao.update(wmsEnterstock);
    }

    @Override
    public int delete(String id) {
        return wmsEnterstockDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsEnterstockDao.deleteBatch(ids);
    }
}
