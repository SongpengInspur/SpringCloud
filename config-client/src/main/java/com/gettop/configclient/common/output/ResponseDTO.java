package com.gettop.configclient.common.output;

/**
 * @author songpeng
 * @date 2019-12-03
 * @param <T>
 */
public class ResponseDTO<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseDTO(){

    }

    public ResponseDTO(int code){
        this.code=code;
    }

    public ResponseDTO(int code, T data){
        this.code = code;
        this.data = data;
    }

    public ResponseDTO(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseDTO(int code, String msg, T entity) {
        this.code = code;
        this.msg = msg;
        this.data=entity;
    }

    public static ResponseDTO success(){
        return new ResponseDTO(ResponseCode.SUCCESS.getCode());
    }

    public static<T> ResponseDTO<T> success(T data){
        return new ResponseDTO(ResponseCode.SUCCESS.getCode(), data);
    }

    public static<T> ResponseDTO<T> success(int code, T data){
        return new ResponseDTO(code, data);
    }

    public static ResponseDTO fail(String msg){
        return new ResponseDTO(ResponseCode.FAILED.getCode(), msg);
    }

    public static ResponseDTO fail(int code, String msg){
        return new ResponseDTO(code, msg);
    }
}