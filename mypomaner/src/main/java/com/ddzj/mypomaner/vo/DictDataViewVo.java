package com.ddzj.mypomaner.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 00:18
 * @Description:
 * @Version:1.0
 **/
public class DictDataViewVo {
    private String id;
    private String dictLabel;

    private String dictValue;

    private String dictCode;

    private String dictName;

    private Integer dictSort;

    //修改时间
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
     * @return dictLabel
     */
    public String getDictLabel() {
        return this.dictLabel;
    }

    /**
     * 设置
     *
     * @param dictLabel
     */
    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    /**
     * 获取
     *
     * @return dictValue
     */
    public String getDictValue() {
        return this.dictValue;
    }

    /**
     * 设置
     *
     * @param dictValue
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取
     *
     * @return dictCode
     */
    public String getDictCode() {
        return this.dictCode;
    }

    /**
     * 设置
     *
     * @param dictCode
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * 获取
     *
     * @return dictName
     */
    public String getDictName() {
        return this.dictName;
    }

    /**
     * 设置
     *
     * @param dictName
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取 修改时间    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     *
     * @return updatedTime 修改时间    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     */
    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    /**
     * 设置 修改时间    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     *
     * @param updatedTime 修改时间    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "AsiaShanghai")
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取
     *
     * @return dictSort
     */
    public Integer getDictSort() {
        return this.dictSort;
    }

    /**
     * 设置
     *
     * @param dictSort
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }
}
