package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxTplIdDao;
import com.fengdu.entity.WxTplIdEntity;
import com.fengdu.service.WxTplIdService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxTplIdService")
public class WxTplIdServiceImpl implements WxTplIdService {
    @Autowired
    private WxTplIdDao wxTplIdDao;

    @Override
    public WxTplIdEntity queryObject(String id) {
        return wxTplIdDao.queryObject(id);
    }

    @Override
    public List<WxTplIdEntity> queryList(Map<String, Object> map) {
        return wxTplIdDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxTplIdDao.queryTotal(map);
    }

    @Override
    public int save(WxTplIdEntity wxTplId) {
        return wxTplIdDao.save(wxTplId);
    }

    @Override
    public int update(WxTplIdEntity wxTplId) {
        return wxTplIdDao.update(wxTplId);
    }

    @Override
    public int delete(String id) {
        return wxTplIdDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxTplIdDao.deleteBatch(ids);
    }
}
