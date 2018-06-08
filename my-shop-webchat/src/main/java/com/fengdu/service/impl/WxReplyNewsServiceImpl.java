package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxReplyNewsDao;
import com.fengdu.entity.WxReplyNewsEntity;
import com.fengdu.service.WxReplyNewsService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxReplyNewsService")
public class WxReplyNewsServiceImpl implements WxReplyNewsService {
    @Autowired
    private WxReplyNewsDao wxReplyNewsDao;

    @Override
    public WxReplyNewsEntity queryObject(String id) {
        return wxReplyNewsDao.queryObject(id);
    }

    @Override
    public List<WxReplyNewsEntity> queryList(Map<String, Object> map) {
        return wxReplyNewsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxReplyNewsDao.queryTotal(map);
    }

    @Override
    public int save(WxReplyNewsEntity wxReplyNews) {
        return wxReplyNewsDao.save(wxReplyNews);
    }

    @Override
    public int update(WxReplyNewsEntity wxReplyNews) {
        return wxReplyNewsDao.update(wxReplyNews);
    }

    @Override
    public int delete(String id) {
        return wxReplyNewsDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxReplyNewsDao.deleteBatch(ids);
    }
}
