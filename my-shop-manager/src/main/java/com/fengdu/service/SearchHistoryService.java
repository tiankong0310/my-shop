package com.fengdu.service;

import java.util.List;
import java.util.Map;

import com.fengdu.entity.SearchHistoryEntity;

/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:10
 */
public interface SearchHistoryService {
	
	SearchHistoryEntity queryObject(Integer id);
	
	List<SearchHistoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SearchHistoryEntity searchHistory);
	
	void update(SearchHistoryEntity searchHistory);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
