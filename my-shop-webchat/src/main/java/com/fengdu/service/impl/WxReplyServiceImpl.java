package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxReplyDao;
import com.fengdu.entity.WxReplyEntity;
import com.fengdu.service.WxReplyService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxReplyService")
public class WxReplyServiceImpl implements WxReplyService {
    @Autowired
    private WxReplyDao wxReplyDao;

    @Override
    public WxReplyEntity queryObject(String id) {
        return wxReplyDao.queryObject(id);
    }

    @Override
    public List<WxReplyEntity> queryList(Map<String, Object> map) {
        return wxReplyDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxReplyDao.queryTotal(map);
    }

    @Override
    public int save(WxReplyEntity wxReply) {
        return wxReplyDao.save(wxReply);
    }

    @Override
    public int update(WxReplyEntity wxReply) {
        return wxReplyDao.update(wxReply);
    }

    @Override
    public int delete(String id) {
        return wxReplyDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxReplyDao.deleteBatch(ids);
    }
}
