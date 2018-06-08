package com.fengdu.dao;


import java.util.List;
import java.util.Map;

import com.fengdu.entity.ResultMap;

/**
 * oracle代码生成器
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017年07月23日 上午13:06:04
 */
public interface SysOracleGeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<ResultMap> queryColumns(String tableName);
}
