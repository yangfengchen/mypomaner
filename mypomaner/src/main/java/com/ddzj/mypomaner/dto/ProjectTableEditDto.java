package com.ddzj.mypomaner.dto;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 19:43
 * @Description:
 * @Version:1.0
 **/
public class ProjectTableEditDto {
    private ProjectTableSaveDto saveDto;

    private List<SelectDto> fieldDbTypeList;


    /**
     * 获取
     *
     * @return saveDto
     */
    public ProjectTableSaveDto getSaveDto() {
        return this.saveDto;
    }

    /**
     * 设置
     *
     * @param saveDto
     */
    public void setSaveDto(ProjectTableSaveDto saveDto) {
        this.saveDto = saveDto;
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
}
