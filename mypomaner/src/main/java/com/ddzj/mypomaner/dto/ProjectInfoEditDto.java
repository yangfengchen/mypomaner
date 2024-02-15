package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 16:33
 * @Description:
 * @Version:1.0
 **/
public class ProjectInfoEditDto {
    private ProjectInfoSaveDto saveDto;
    private List<SelectDto> dbTypeList;
    private List<SelectDto> codeTypeList;
    private List<SelectDto> tableTemplateList;

    /**
     * 获取
     *
     * @return saveDto
     */
    public ProjectInfoSaveDto getSaveDto() {
        return this.saveDto;
    }

    /**
     * 设置
     *
     * @param saveDto
     */
    public void setSaveDto(ProjectInfoSaveDto saveDto) {
        this.saveDto = saveDto;
    }

    /**
     * 获取
     *
     * @return dbTypeList
     */
    public List<SelectDto> getDbTypeList() {
        return this.dbTypeList;
    }

    /**
     * 设置
     *
     * @param dbTypeList
     */
    public void setDbTypeList(List<SelectDto> dbTypeList) {
        this.dbTypeList = dbTypeList;
    }

    /**
     * 获取
     *
     * @return codeTypeList
     */
    public List<SelectDto> getCodeTypeList() {
        return this.codeTypeList;
    }

    /**
     * 设置
     *
     * @param codeTypeList
     */
    public void setCodeTypeList(List<SelectDto> codeTypeList) {
        this.codeTypeList = codeTypeList;
    }

    /**
     * 获取
     *
     * @return tableTemplateList
     */
    public List<SelectDto> getTableTemplateList() {
        return this.tableTemplateList;
    }

    /**
     * 设置
     *
     * @param tableTemplateList
     */
    public void setTableTemplateList(List<SelectDto> tableTemplateList) {
        this.tableTemplateList = tableTemplateList;
    }
}
