package com.linglan.syt.common.result;


/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum MsgCode implements IErrorCode {
    //基本
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    //通用
    PARAMS_ERROR(11000, "参数不正确"),
    DATE_ERROR(11001, "日期解析异常"),
    SYSTEM_ERROR(11002, "系统异常"),

    //课程分类
    CATEGORY_NOTEXIST(20000, "目录不存在"),

    //用户
    USERNAME_PASSWORD_ERROR(40001, "用户名或密码错误"),
    PASSWORD_ERROR(40002, "密码错误"),
    ACCOUNT_FORBIDDEN(40003, "账号禁用"),
    USER_EXIST(40004, "用户已存在"),
    USER_NOTEXIST(40005, "用户不存在"),
    ADMIN_NOTFORBIDDEN(40006, "admin账号无法被禁用"),
    ;
    private long code;
    private String message;

    private MsgCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
