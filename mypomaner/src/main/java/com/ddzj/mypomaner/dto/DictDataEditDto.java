package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 14:36
 * @Description:
 * @Version:1.0
 **/
public class DictDataEditDto {
    //字典表列表
    private List<SelectDto> dictTypeList;

    private DictDataSaveDto dictDataSaveDto;


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
     * 获取
     *
     * @return dictDataSaveVo
     */
    public DictDataSaveDto getDictDataSaveVo() {
        return this.dictDataSaveDto;
    }

    /**
     * 设置
     *
     * @param dictDataSaveDto
     */
    public void setDictDataSaveVo(DictDataSaveDto dictDataSaveDto) {
        this.dictDataSaveDto = dictDataSaveDto;
    }
}
