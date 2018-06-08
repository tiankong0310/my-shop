package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WmsBacksaleDetailDao;
import com.fengdu.entity.WmsBacksaleDetailEntity;
import com.fengdu.service.WmsBacksaleDetailService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
@Service("wmsBacksaleDetailService")
public class WmsBacksaleDetailServiceImpl implements WmsBacksaleDetailService {
    @Autowired
    private WmsBacksaleDetailDao wmsBacksaleDetailDao;

    @Override
    public WmsBacksaleDetailEntity queryObject(String id) {
        return wmsBacksaleDetailDao.queryObject(id);
    }

    @Override
    public List<WmsBacksaleDetailEntity> queryList(Map<String, Object> map) {
        return wmsBacksaleDetailDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wmsBacksaleDetailDao.queryTotal(map);
    }

    @Override
    public int save(WmsBacksaleDetailEntity wmsBacksaleDetail) {
        return wmsBacksaleDetailDao.save(wmsBacksaleDetail);
    }

    @Override
    public int update(WmsBacksaleDetailEntity wmsBacksaleDetail) {
        return wmsBacksaleDetailDao.update(wmsBacksaleDetail);
    }

    @Override
    public int delete(String id) {
        return wmsBacksaleDetailDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wmsBacksaleDetailDao.deleteBatch(ids);
    }
}
