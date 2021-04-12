package com.linglan.syt.common.exception;


import com.linglan.syt.common.result.MsgCode;

public class BusinessException extends BaseException {

	public BusinessException(MsgCode codeMsg) {
		super(codeMsg);
	}
//	public BusinessException(MsgCode codeMsg, String uniqueKey) {
//		super(codeMsg, uniqueKey);
//	}
//	public BusinessException(MsgCode codeMsg, Throwable e) {
//		super(codeMsg, e);
//	}
}
