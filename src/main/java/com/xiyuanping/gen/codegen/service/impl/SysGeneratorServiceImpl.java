/*
 *      Copyright (c) 2018-2025, He Zenghui All rights reserved.
 */

package com.xiyuanping.gen.codegen.service.impl;

import cn.hutool.core.io.IoUtil;
import com.xiyuanping.gen.codegen.entity.GenConfig;
import com.xiyuanping.gen.codegen.mapper.SysGeneratorMapper;
import com.xiyuanping.gen.codegen.service.SysGeneratorService;
import com.xiyuanping.gen.codegen.util.GenUtils;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;


/**
 * 代码生成器
 *
 * @author He Zenghui
 * @date 2018-07-30
 */
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {
	@Autowired
	private SysGeneratorMapper sysGeneratorMapper;

	/**
	 * 分页查询表
	 *
	 * @param tableName 查询条件
	 * @return List
	 */
	@Override
	public String getPage(String tableName) {
		var list = new ArrayList<String>();
		sysGeneratorMapper.queryList(tableName).forEach(tableMap -> {
			list.add(String.join("  ", tableMap
					.values()));
		});

		return list.stream()
				.collect(Collectors.joining(System.getProperty("line.separator")));
	}

	/**
	 * 生成代码
	 *
	 * @param genConfig 生成配置
	 * @return byte[]
	 */
	@Override
	public byte[] generatorCode(GenConfig genConfig) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		//查询表信息
		Map<String, String> table = queryTable(genConfig.getTableName());
		if (table == null)
			throw new Exception("该表不存在");
		String delete = isHaveDelete(genConfig.getTableName()) ;
		//查询列信息
		List<Map<String, String>> columns = queryColumns(genConfig.getTableName());
		//生成代码
		GenUtils.generatorCode(genConfig, table, columns, zip);
		IoUtil.close(zip);
		return outputStream.toByteArray();
	}


	private Map<String, String> queryTable(String tableName) {
		return sysGeneratorMapper.queryTable(tableName);
	}

	private List<Map<String, String>> queryColumns(String tableName) {
		return sysGeneratorMapper.queryColumns(tableName);
	}
	private String isHaveDelete(String tableName) {
		return sysGeneratorMapper.isHaveDelete(tableName);
	}

}
