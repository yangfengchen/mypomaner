package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-02 08:08
 * @Description:
 * @Version:1.0
 **/
public class FieldConfigEditDto {
    private List<FieldConfigSaveDto> fieldConfigSaveDtos;

    private List<SelectDto> dbList;

    private List<SelectDto> fieldDbTypeList;



    /**
     * 获取
     *
     * @return dbList
     */
    public List<SelectDto> getDbList() {
        return this.dbList;
    }

    /**
     * 设置
     *
     * @param dbList
     */
    public void setDbList(List<SelectDto> dbList) {
        this.dbList = dbList;
    }

    /**
     * 获取
     *
     * @return fieldDbTypeList
     */
    public List<SelectDto> getFieldDbTypeList() {
        return this.fieldDbTypeList;
    }

    /**
     * 设置
     *
     * @param fieldDbTypeList
     */
    public void setFieldDbTypeList(List<SelectDto> fieldDbTypeList) {
        this.fieldDbTypeList = fieldDbTypeList;
    }

    /**
     * 获取
     *
     * @return fieldConfigSaveDtos
     */
    public List<FieldConfigSaveDto> getFieldConfigSaveDtos() {
        return this.fieldConfigSaveDtos;
    }

    /**
     * 设置
     *
     * @param fieldConfigSaveDtos
     */
    public void setFieldConfigSaveDtos(List<FieldConfigSaveDto> fieldConfigSaveDtos) {
        this.fieldConfigSaveDtos = fieldConfigSaveDtos;
    }
}
