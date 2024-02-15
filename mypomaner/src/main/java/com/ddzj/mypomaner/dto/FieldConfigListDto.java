package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * 字段配置 Dto
 * @Author:yangzibo
 * @CreateTime:2024-02-14 20:44
 * @Description:
 * @Version:1.0
 **/
public class FieldConfigListDto {
    // 数据库类型
    private List<SelectDto> dbList;
    // 字段类型
    private List<SelectDto> fieldDbTypeList;

    /**
     * 获取 数据库类型
     *
     * @return dbList 数据库类型
     */
    public List<SelectDto> getDbList() {
        return this.dbList;
    }

    /**
     * 设置 数据库类型
     *
     * @param dbList 数据库类型
     */
    public void setDbList(List<SelectDto> dbList) {
        this.dbList = dbList;
    }

    /**
     * 获取 字段类型
     *
     * @return fieldDbTypeList 字段类型
     */
    public List<SelectDto> getFieldDbTypeList() {
        return this.fieldDbTypeList;
    }

    /**
     * 设置 字段类型
     *
     * @param fieldDbTypeList 字段类型
     */
    public void setFieldDbTypeList(List<SelectDto> fieldDbTypeList) {
        this.fieldDbTypeList = fieldDbTypeList;
    }
}
