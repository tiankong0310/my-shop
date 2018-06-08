package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxMassSendDao;
import com.fengdu.entity.WxMassSendEntity;
import com.fengdu.service.WxMassSendService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
@Service("wxMassSendService")
public class WxMassSendServiceImpl implements WxMassSendService {
    @Autowired
    private WxMassSendDao wxMassSendDao;

    @Override
    public WxMassSendEntity queryObject(String id) {
        return wxMassSendDao.queryObject(id);
    }

    @Override
    public List<WxMassSendEntity> queryList(Map<String, Object> map) {
        return wxMassSendDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxMassSendDao.queryTotal(map);
    }

    @Override
    public int save(WxMassSendEntity wxMassSend) {
        return wxMassSendDao.save(wxMassSend);
    }

    @Override
    public int update(WxMassSendEntity wxMassSend) {
        return wxMassSendDao.update(wxMassSend);
    }

    @Override
    public int delete(String id) {
        return wxMassSendDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxMassSendDao.deleteBatch(ids);
    }
}
