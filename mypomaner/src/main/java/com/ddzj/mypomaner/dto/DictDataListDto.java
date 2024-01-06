package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 13:06
 * @Description:
 * @Version:1.0
 **/
public class DictDataListDto {
    //字典表列表
    private List<SelectDto> dictTypeList;
    //字典表类型
    private String dictType;

    /**
     * 获取 字典表列表
     *
     * @return dictTypeList 字典表列表
     */
    public List<SelectDto> getDictTypeList() {
        return this.dictTypeList;
    }

    /**
     * 设置 字典表列表
     *
     * @param dictTypeList 字典表列表
     */
    public void setDictTypeList(List<SelectDto> dictTypeList) {
        this.dictTypeList = dictTypeList;
    }

    /**
     * 获取 字典表类型
     *
     * @return dictType 字典表类型
     */
    public String getDictType() {
        return this.dictType;
    }

    /**
     * 设置 字典表类型
     *
     * @param dictType 字典表类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
}
