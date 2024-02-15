package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 14:11
 * @Description:
 * @Version:1.0
 **/
public class FieldTemplateSearchDto {
    private String tableId;
    private Boolean enabled;


    /**
     * 获取
     *
     * @return tableId
     */
    public String getTableId() {
        return this.tableId;
    }

    /**
     * 设置
     *
     * @param tableId
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取
     *
     * @return enabled
     */
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * 设置
     *
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
