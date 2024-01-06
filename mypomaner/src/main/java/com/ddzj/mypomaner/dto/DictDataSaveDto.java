package com.ddzj.mypomaner.dto;

import org.wildfly.common.annotation.NotNull;

import java.io.Serializable;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 14:36
 * @Description:
 * @Version:1.0
 **/
public class DictDataSaveDto implements Serializable {
    private String id;
    @NotNull
    private String dictLabel;

    @NotNull
    private String dictValue;

    private Integer dictSort;

    @NotNull
    private String dictCode;

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
}
