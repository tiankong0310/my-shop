package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxReplyTxtDao;
import com.fengdu.entity.WxReplyTxtEntity;
import com.fengdu.service.WxReplyTxtService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxReplyTxtService")
public class WxReplyTxtServiceImpl implements WxReplyTxtService {
    @Autowired
    private WxReplyTxtDao wxReplyTxtDao;

    @Override
    public WxReplyTxtEntity queryObject(String id) {
        return wxReplyTxtDao.queryObject(id);
    }

    @Override
    public List<WxReplyTxtEntity> queryList(Map<String, Object> map) {
        return wxReplyTxtDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxReplyTxtDao.queryTotal(map);
    }

    @Override
    public int save(WxReplyTxtEntity wxReplyTxt) {
        return wxReplyTxtDao.save(wxReplyTxt);
    }

    @Override
    public int update(WxReplyTxtEntity wxReplyTxt) {
        return wxReplyTxtDao.update(wxReplyTxt);
    }

    @Override
    public int delete(String id) {
        return wxReplyTxtDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxReplyTxtDao.deleteBatch(ids);
    }
}
