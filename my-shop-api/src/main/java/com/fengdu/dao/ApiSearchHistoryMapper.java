package com.fengdu.dao;

import com.fengdu.dao.BaseDao;
import com.fengdu.entity.SearchHistoryVo;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface ApiSearchHistoryMapper extends BaseDao<SearchHistoryVo> {
    int deleteByUserId(@Param("user_id") Long userId);
}
