package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMenuDao;
import com.fengdu.entity.WxMenuEntity;
import com.fengdu.service.WxMenuService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxMenuService")
public class WxMenuServiceImpl implements WxMenuService {
    @Autowired
    private WxMenuDao wxMenuDao;

    @Override
    public WxMenuEntity queryObject(String id) {
        return wxMenuDao.queryObject(id);
    }

    @Override
    public List<WxMenuEntity> queryList(Map<String, Object> map) {
        return wxMenuDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMenuDao.queryTotal(map);
    }

    @Override
    public int save(WxMenuEntity wxMenu) {
        return wxMenuDao.save(wxMenu);
    }

    @Override
    public int update(WxMenuEntity wxMenu) {
        return wxMenuDao.update(wxMenu);
    }

    @Override
    public int delete(String id) {
        return wxMenuDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMenuDao.deleteBatch(ids);
    }
}
