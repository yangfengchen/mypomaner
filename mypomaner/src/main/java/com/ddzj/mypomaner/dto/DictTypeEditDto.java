package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:38
 * @Description:
 * @Version:1.0
 **/
public class DictTypeEditDto {
    private String id;
    private String dictName;

    private String dictType;

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
     * 获取
     *
     * @return dictType
     */
    public String getDictType() {
        return this.dictType;
    }

    /**
     * 设置
     *
     * @param dictType
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
}
