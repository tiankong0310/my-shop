package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsBacksaleDao;
import com.fengdu.entity.WmsBacksaleEntity;
import com.fengdu.service.WmsBacksaleService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Service("wmsBacksaleService")
public class WmsBacksaleServiceImpl implements WmsBacksaleService {
    @Autowired
    private WmsBacksaleDao wmsBacksaleDao;

    @Override
    public WmsBacksaleEntity queryObject(String id) {
        return wmsBacksaleDao.queryObject(id);
    }

    @Override
    public List<WmsBacksaleEntity> queryList(Map<String, Object> map) {
        return wmsBacksaleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsBacksaleDao.queryTotal(map);
    }

    @Override
    public int save(WmsBacksaleEntity wmsBacksale) {
        return wmsBacksaleDao.save(wmsBacksale);
    }

    @Override
    public int update(WmsBacksaleEntity wmsBacksale) {
        return wmsBacksaleDao.update(wmsBacksale);
    }

    @Override
    public int delete(String id) {
        return wmsBacksaleDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsBacksaleDao.deleteBatch(ids);
    }
}
