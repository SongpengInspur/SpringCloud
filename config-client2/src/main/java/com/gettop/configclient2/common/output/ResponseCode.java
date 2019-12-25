package com.gettop.configclient2.common.output;

public enum ResponseCode {
    SUCCESS(200, "成功"),
    FAILED(300, "失败"),
    FILE_EXISTS(1001, "文件已存在"),
    DIIRECTORY_EXISTS(1002, "文件夹已存在"),
    PARAMETER_VALIDATION_FAILED(2001, "参数不合法");

    private int code;
    private String message;
    private ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
