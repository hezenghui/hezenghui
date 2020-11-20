/*
 *      Copyright (c) 2018-2025, He Zenghui All rights reserved.
 */

package com.xiyuanping.gen.codegen.service;

import com.xiyuanping.gen.codegen.entity.GenConfig;

/**
 * @author He Zenghui
 * @date 2018/7/29
 */
public interface SysGeneratorService  {
	/**
	 * 生成代码
	 *
	 * @param tableName 表名称
	 * @return byte
	 */
	byte[] generatorCode(GenConfig tableName) throws Exception;

	/**
	 * 分页查询表
	 * @param tableName 表名
	 * @return list
	 */
	String getPage(String tableName);
}
