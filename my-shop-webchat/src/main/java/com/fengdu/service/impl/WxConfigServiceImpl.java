package com.fengdu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdu.dao.WxConfigDao;
import com.fengdu.entity.WxConfigEntity;
import com.fengdu.service.WxConfigService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxConfigService")
public class WxConfigServiceImpl implements WxConfigService {
    @Autowired
    private WxConfigDao wxConfigDao;

    @Override
    public WxConfigEntity queryObject(String id) {
        return wxConfigDao.queryObject(id);
    }

    @Override
    public List<WxConfigEntity> queryList(Map<String, Object> map) {
        return wxConfigDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxConfigDao.queryTotal(map);
    }

    @Override
    public int save(WxConfigEntity wxConfig) {
        return wxConfigDao.save(wxConfig);
    }

    @Override
    public int update(WxConfigEntity wxConfig) {
        return wxConfigDao.update(wxConfig);
    }

    @Override
    public int delete(String id) {
        return wxConfigDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxConfigDao.deleteBatch(ids);
    }
}
