package com.fengdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fengdu.dao.WxTplListDao;
import com.fengdu.entity.WxTplListEntity;
import com.fengdu.service.WxTplListService;

/**
 * Service实现类
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
@Service("wxTplListService")
public class WxTplListServiceImpl implements WxTplListService {
    @Autowired
    private WxTplListDao wxTplListDao;

    @Override
    public WxTplListEntity queryObject(String id) {
        return wxTplListDao.queryObject(id);
    }

    @Override
    public List<WxTplListEntity> queryList(Map<String, Object> map) {
        return wxTplListDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wxTplListDao.queryTotal(map);
    }

    @Override
    public int save(WxTplListEntity wxTplList) {
        return wxTplListDao.save(wxTplList);
    }

    @Override
    public int update(WxTplListEntity wxTplList) {
        return wxTplListDao.update(wxTplList);
    }

    @Override
    public int delete(String id) {
        return wxTplListDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return wxTplListDao.deleteBatch(ids);
    }
}
