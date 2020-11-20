/*
 *    Copyright (c) 2018-2025, He Zenghui All rights reserved.
 */


package com.xiyuanping.gen.codegen.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author He Zenghui
 * @date 2018/8/2
 * 生成配置
 */
@Data
@Builder
public class GenConfig {
	/**
	 * 包名
	 */
	private String packageName;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
	 * 表前缀
	 */
	private String tablePrefix;

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 表备注
	 */
	private String comments;
}
