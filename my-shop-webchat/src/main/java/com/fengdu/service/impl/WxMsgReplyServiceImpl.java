package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMsgReplyDao;
import com.fengdu.entity.WxMsgReplyEntity;
import com.fengdu.service.WxMsgReplyService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxMsgReplyService")
public class WxMsgReplyServiceImpl implements WxMsgReplyService {
    @Autowired
    private WxMsgReplyDao wxMsgReplyDao;

    @Override
    public WxMsgReplyEntity queryObject(String id) {
        return wxMsgReplyDao.queryObject(id);
    }

    @Override
    public List<WxMsgReplyEntity> queryList(Map<String, Object> map) {
        return wxMsgReplyDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMsgReplyDao.queryTotal(map);
    }

    @Override
    public int save(WxMsgReplyEntity wxMsgReply) {
        return wxMsgReplyDao.save(wxMsgReply);
    }

    @Override
    public int update(WxMsgReplyEntity wxMsgReply) {
        return wxMsgReplyDao.update(wxMsgReply);
    }

    @Override
    public int delete(String id) {
        return wxMsgReplyDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMsgReplyDao.deleteBatch(ids);
    }
}
