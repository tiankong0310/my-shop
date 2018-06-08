package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMsgDao;
import com.fengdu.entity.WxMsgEntity;
import com.fengdu.service.WxMsgService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxMsgService")
public class WxMsgServiceImpl implements WxMsgService {
    @Autowired
    private WxMsgDao wxMsgDao;

    @Override
    public WxMsgEntity queryObject(String id) {
        return wxMsgDao.queryObject(id);
    }

    @Override
    public List<WxMsgEntity> queryList(Map<String, Object> map) {
        return wxMsgDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMsgDao.queryTotal(map);
    }

    @Override
    public int save(WxMsgEntity wxMsg) {
        return wxMsgDao.save(wxMsg);
    }

    @Override
    public int update(WxMsgEntity wxMsg) {
        return wxMsgDao.update(wxMsg);
    }

    @Override
    public int delete(String id) {
        return wxMsgDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMsgDao.deleteBatch(ids);
    }
}
