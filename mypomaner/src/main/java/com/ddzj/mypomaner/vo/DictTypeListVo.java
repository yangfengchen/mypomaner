package com.ddzj.mypomaner.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 00:18
 * @Description:
 * @Version:1.0
 **/
public class DictTypeListVo {
    private String id;
    private String dictName;

    private String dictType;

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

    /**
     * 获取 修改时间
     *
     * @return updatedTime 修改时间
     */
    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    /**
     * 设置 修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
