package com.ddzj.mypomaner.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-01 22:45
 * @Description:
 * @Version:1.0
 **/
public class FieldConfigListVo {
    private String id;

    private String databaseType;

    private String databaseTypeName;

    private String fieldDbType;

    private String fieldDbTypeName;

    private String fieldCodeType;

    private String fieldBaseType;

    private String fieldDefLen;

    private String fieldDefDecimal;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    protected LocalDateTime updatedTime;


    /**
     * 获取
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return databaseType
     */
    public String getDatabaseType() {
        return this.databaseType;
    }

    /**
     * 设置
     *
     * @param databaseType
     */
    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    /**
     * 获取
     *
     * @return databaseTypeName
     */
    public String getDatabaseTypeName() {
        return this.databaseTypeName;
    }

    /**
     * 设置
     *
     * @param databaseTypeName
     */
    public void setDatabaseTypeName(String databaseTypeName) {
        this.databaseTypeName = databaseTypeName;
    }

    /**
     * 获取
     *
     * @return fieldDbType
     */
    public String getFieldDbType() {
        return this.fieldDbType;
    }

    /**
     * 设置
     *
     * @param fieldDbType
     */
    public void setFieldDbType(String fieldDbType) {
        this.fieldDbType = fieldDbType;
    }

    /**
     * 获取
     *
     * @return fieldDbTypeName
     */
    public String getFieldDbTypeName() {
        return this.fieldDbTypeName;
    }

    /**
     * 设置
     *
     * @param fieldDbTypeName
     */
    public void setFieldDbTypeName(String fieldDbTypeName) {
        this.fieldDbTypeName = fieldDbTypeName;
    }

    /**
     * 获取
     *
     * @return fieldCodeType
     */
    public String getFieldCodeType() {
        return this.fieldCodeType;
    }

    /**
     * 设置
     *
     * @param fieldCodeType
     */
    public void setFieldCodeType(String fieldCodeType) {
        this.fieldCodeType = fieldCodeType;
    }

    /**
     * 获取
     *
     * @return fieldBaseType
     */
    public String getFieldBaseType() {
        return this.fieldBaseType;
    }

    /**
     * 设置
     *
     * @param fieldBaseType
     */
    public void setFieldBaseType(String fieldBaseType) {
        this.fieldBaseType = fieldBaseType;
    }

    /**
     * 获取
     *
     * @return fieldDefLen
     */
    public String getFieldDefLen() {
        return this.fieldDefLen;
    }

    /**
     * 设置
     *
     * @param fieldDefLen
     */
    public void setFieldDefLen(String fieldDefLen) {
        this.fieldDefLen = fieldDefLen;
    }

    /**
     * 获取
     *
     * @return fieldDefDecimal
     */
    public String getFieldDefDecimal() {
        return this.fieldDefDecimal;
    }

    /**
     * 设置
     *
     * @param fieldDefDecimal
     */
    public void setFieldDefDecimal(String fieldDefDecimal) {
        this.fieldDefDecimal = fieldDefDecimal;
    }

    /**
     * 获取 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     *
     * @return updatedTime @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     */
    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    /**
     * 设置 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     *
     * @param updatedTime @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
