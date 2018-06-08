package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdu.dao.UserLevelDao;
import com.fengdu.entity.UserLevelEntity;
import com.fengdu.service.UserLevelService;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 16:52:22
 */
@Service("userLevelService")
public class UserLevelServiceImpl implements UserLevelService {
    @Autowired
    private UserLevelDao userLevelDao;

    @Override
    public UserLevelEntity queryObject(Integer id) {
        return userLevelDao.queryObject(id);
    }

    @Override
    public List<UserLevelEntity> queryList(Map<String, Object> map) {
        return userLevelDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userLevelDao.queryTotal(map);
    }

    @Override
    public int save(UserLevelEntity userLevel) {
        return userLevelDao.save(userLevel);
    }

    @Override
    public int update(UserLevelEntity userLevel) {
        return userLevelDao.update(userLevel);
    }

    @Override
    public int delete(Integer id) {
        return userLevelDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return userLevelDao.deleteBatch(ids);
    }
}
