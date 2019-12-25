package com.gettop.schedule.common.log;

/**
 * 本地日志枚举
 * @author songpeng
 * @date 2019/12/07
 *
 */
public enum  LogEnum {

    BUSINESS("business"),
    PLATFORM("platform"),
    DB("db"),
    EXCEPTION("exception");

    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
