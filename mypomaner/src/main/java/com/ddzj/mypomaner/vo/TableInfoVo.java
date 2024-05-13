package com.ddzj.mypomaner.vo;

/**
 * @Author:yangzibo
 * @CreateTime:2024-05-01 00:33
 * @Description:
 * @Version:1.0
 **/
public class TableInfoVo {
    // 表名称
    private String tableName;
    // 字段名称
    private String columnName;
    // 数据类型
    private String dataType;
    // 是否主键
    private String extra;
    // 注释
    private String columnComment;


    /**
     * 获取 表名称
     *
     * @return tableName 表名称
     */
    public String getTableName() {
        return this.tableName;
    }

    /**
     * 设置 表名称
     *
     * @param tableName 表名称
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取 字段名称
     *
     * @return columnName 字段名称
     */
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * 设置 字段名称
     *
     * @param columnName 字段名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获取 数据类型
     *
     * @return dataType 数据类型
     */
    public String getDataType() {
        return this.dataType;
    }

    /**
     * 设置 数据类型
     *
     * @param dataType 数据类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取 是否主键
     *
     * @return extra 是否主键
     */
    public String getExtra() {
        return this.extra;
    }

    /**
     * 设置 是否主键
     *
     * @param extra 是否主键
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * 获取 注释
     *
     * @return columnComment 注释
     */
    public String getColumnComment() {
        return this.columnComment;
    }

    /**
     * 设置 注释
     *
     * @param columnComment 注释
     */
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
