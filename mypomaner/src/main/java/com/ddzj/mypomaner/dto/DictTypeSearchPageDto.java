package com.ddzj.mypomaner.dto;

/**
 *
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:01
 * @Description:
 * @Version:1.0
 **/
public class DictTypeSearchPageDto extends PageSearchDto {
    private String dictType;

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
