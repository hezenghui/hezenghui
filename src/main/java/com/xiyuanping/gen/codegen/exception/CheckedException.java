/*
 *    Copyright (c) 2018-2025, He Zenghui All rights reserved.
 */

package com.xiyuanping.gen.codegen.exception;

import lombok.NoArgsConstructor;

/**
 * @author He Zenghui
 * @date 😴2018年06月22日16:21:57
 */
@NoArgsConstructor
public class CheckedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CheckedException(String message) {
		super(message);
	}

	public CheckedException(Throwable cause) {
		super(cause);
	}

	public CheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
