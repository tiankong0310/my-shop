package com.fengdu.service;

import com.fengdu.entity.CmsClassLinkEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
public interface CmsClassLinkService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    CmsClassLinkEntity queryObject(String classid);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<CmsClassLinkEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param cmsClassLink 实体
     * @return 保存条数
     */
    int save(CmsClassLinkEntity cmsClassLink);

    /**
     * 根据主键更新实体
     *
     * @param cmsClassLink 实体
     * @return 更新条数
     */
    int update(CmsClassLinkEntity cmsClassLink);

    /**
     * 根据主键删除
     *
     * @param classid
     * @return 删除条数
     */
    int delete(String classid);

    /**
     * 根据主键批量删除
     *
     * @param classids
     * @return 删除条数
     */
    int deleteBatch(String[]classids);
}
