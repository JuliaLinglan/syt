package com.linglan.syt.common.exception;

import com.linglan.syt.common.result.MsgCode;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -3177085408025135330L;
	private String msg;
	private long errcode;
	private String uniqueKey;
	private Throwable exception;

	public BaseException(MsgCode codeMsg, Throwable e) {
		super(codeMsg.getMessage(), e);
		this.errcode = codeMsg.getCode();
		this.msg = codeMsg.getMessage();
		this.exception = e;
	}

	public BaseException(MsgCode codeMsg) {
		super(codeMsg.getMessage());
		this.errcode = codeMsg.getCode();
		this.msg = codeMsg.getMessage();
	}

	public BaseException(MsgCode codeMsg, String uniqueKey) {
		super(codeMsg.getMessage());
		this.errcode = codeMsg.getCode();
		this.msg = codeMsg.getMessage();
		this.uniqueKey = uniqueKey;
	}


	public String getUniqueKey() {
		return uniqueKey;
	}

	public long getErrcode() {
		return errcode;
	}

	public String getMsg() {
		return msg;
	}

	public Throwable getException() {
		return exception;
	}
}
