package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMassDao;
import com.fengdu.entity.WxMassEntity;
import com.fengdu.service.WxMassService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxMassService")
public class WxMassServiceImpl implements WxMassService {
    @Autowired
    private WxMassDao wxMassDao;

    @Override
    public WxMassEntity queryObject(String id) {
        return wxMassDao.queryObject(id);
    }

    @Override
    public List<WxMassEntity> queryList(Map<String, Object> map) {
        return wxMassDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMassDao.queryTotal(map);
    }

    @Override
    public int save(WxMassEntity wxMass) {
        return wxMassDao.save(wxMass);
    }

    @Override
    public int update(WxMassEntity wxMass) {
        return wxMassDao.update(wxMass);
    }

    @Override
    public int delete(String id) {
        return wxMassDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMassDao.deleteBatch(ids);
    }
}
