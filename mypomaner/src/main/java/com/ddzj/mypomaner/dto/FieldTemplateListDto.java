package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 10:04
 * @Description:
 * @Version:1.0
 **/
public class FieldTemplateListDto {
    // 表类型
    private List<SelectDto> tableTemplateList;

    // 字段类型
    private List<SelectDto> fieldDbTypeList;


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

    /**
     * 获取 表类型
     *
     * @return tableTemplateList 表类型
     */
    public List<SelectDto> getTableTemplateList() {
        return this.tableTemplateList;
    }

    /**
     * 设置 表类型
     *
     * @param tableTemplateList 表类型
     */
    public void setTableTemplateList(List<SelectDto> tableTemplateList) {
        this.tableTemplateList = tableTemplateList;
    }
}
