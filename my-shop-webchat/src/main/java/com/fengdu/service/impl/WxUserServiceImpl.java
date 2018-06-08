package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxUserDao;
import com.fengdu.entity.WxUserEntity;
import com.fengdu.service.WxUserService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserDao wxUserDao;

    @Override
    public WxUserEntity queryObject(String id) {
        return wxUserDao.queryObject(id);
    }

    @Override
    public List<WxUserEntity> queryList(Map<String, Object> map) {
        return wxUserDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxUserDao.queryTotal(map);
    }

    @Override
    public int save(WxUserEntity wxUser) {
        return wxUserDao.save(wxUser);
    }

    @Override
    public int update(WxUserEntity wxUser) {
        return wxUserDao.update(wxUser);
    }

    @Override
    public int delete(String id) {
        return wxUserDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxUserDao.deleteBatch(ids);
    }
}
