package com.ddzj.mypomaner.dto;

/**
 *
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:01
 * @Description:
 * @Version:1.0
 **/
public class DictDataSearchDto extends PageSearchDto {
    private String dictCode;

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
