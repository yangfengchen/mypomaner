package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-01 22:40
 * @Description:
 * @Version:1.0
 **/
public class FieldConfigSearchPageDto extends PageSearchDto {

    // 数据库类型
    private String databaseType;

    // 数据库字段类型
    private String fieldDbType;

    /**
     * 获取 数据库类型
     *
     * @return databaseType 数据库类型
     */
    public String getDatabaseType() {
        return this.databaseType;
    }

    /**
     * 设置 数据库类型
     *
     * @param databaseType 数据库类型
     */
    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    /**
     * 获取 数据库字段类型
     *
     * @return fieldDbType 数据库字段类型
     */
    public String getFieldDbType() {
        return this.fieldDbType;
    }

    /**
     * 设置 数据库字段类型
     *
     * @param fieldDbType 数据库字段类型
     */
    public void setFieldDbType(String fieldDbType) {
        this.fieldDbType = fieldDbType;
    }
}
