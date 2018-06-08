package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxTplLogDao;
import com.fengdu.entity.WxTplLogEntity;
import com.fengdu.service.WxTplLogService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxTplLogService")
public class WxTplLogServiceImpl implements WxTplLogService {
    @Autowired
    private WxTplLogDao wxTplLogDao;

    @Override
    public WxTplLogEntity queryObject(String id) {
        return wxTplLogDao.queryObject(id);
    }

    @Override
    public List<WxTplLogEntity> queryList(Map<String, Object> map) {
        return wxTplLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxTplLogDao.queryTotal(map);
    }

    @Override
    public int save(WxTplLogEntity wxTplLog) {
        return wxTplLogDao.save(wxTplLog);
    }

    @Override
    public int update(WxTplLogEntity wxTplLog) {
        return wxTplLogDao.update(wxTplLog);
    }

    @Override
    public int delete(String id) {
        return wxTplLogDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxTplLogDao.deleteBatch(ids);
    }
}
