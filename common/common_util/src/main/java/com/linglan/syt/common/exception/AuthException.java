package com.linglan.syt.common.exception;


import com.linglan.syt.common.result.MsgCode;

public class AuthException extends BaseException {

	public AuthException(MsgCode codeMsg) {
		super(codeMsg);
	}
	public AuthException(MsgCode codeMsg, String uniqueKey) {
		super(codeMsg, uniqueKey);
	}
	public AuthException(MsgCode codeMsg, Throwable e) {
		super(codeMsg, e);
	}
}
