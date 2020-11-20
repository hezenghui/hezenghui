/*
 *    Copyright (c) 2018-2025, He Zenghui All rights reserved.
 */

package com.xiyuanping.gen.codegen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author He Zenghui
 * @date 2018-07-30
 */
@Mapper
public interface SysGeneratorMapper {

	/**
	 * 分页查询表格
	 *
	 * @param tableName 表名
	 * @return List
	 */
	List<Map<String, String>> queryList(@Param("tableName") String tableName);

	/**
	 * 查询表信息
	 *
	 * @param tableName 表名称
	 * @return Map
	 */
	Map<String, String> queryTable(String tableName);

	/**
	 * 查询表列信息
	 *
	 * @param tableName 表名称
	 * @return List
	 */
	List<Map<String, String>> queryColumns(String tableName);

	String isHaveDelete(String tableName);
}
