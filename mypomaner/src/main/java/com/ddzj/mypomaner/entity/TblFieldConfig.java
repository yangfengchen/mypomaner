package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目配置;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_FIELD_CONFIG")
public class TblFieldConfig extends AbstractEntity  {

    private static final long serialVersionUID = 1L;


    private String databaseType;

    private String fieldDbType;

    private String fieldCodeType;

    private String fieldBaseType;

    private String fieldDefLen;

    private String fieldDefDecimal;

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getFieldDbType() {
        return fieldDbType;
    }

    public void setFieldDbType(String fieldDbType) {
        this.fieldDbType = fieldDbType;
    }

    public String getFieldCodeType() {
        return fieldCodeType;
    }

    public void setFieldCodeType(String fieldCodeType) {
        this.fieldCodeType = fieldCodeType;
    }

    public String getFieldBaseType() {
        return fieldBaseType;
    }

    public void setFieldBaseType(String fieldBaseType) {
        this.fieldBaseType = fieldBaseType;
    }

    public String getFieldDefLen() {
        return fieldDefLen;
    }

    public void setFieldDefLen(String fieldDefLen) {
        this.fieldDefLen = fieldDefLen;
    }

    public String getFieldDefDecimal() {
        return fieldDefDecimal;
    }

    public void setFieldDefDecimal(String fieldDefDecimal) {
        this.fieldDefDecimal = fieldDefDecimal;
    }

    @Override
    public String toString() {
        return "TblFieldConfig{" + "id = " + id + ", tenantId = " + tenantId + ", revision = " + revision + ", createdBy = " + createdBy + ", createdTime = " + createdTime + ", updatedBy = " + updatedBy + ", updatedTime = " + updatedTime + ", databaseType = " + databaseType + ", fieldDbType = " + fieldDbType + ", fieldCodeType = " + fieldCodeType + ", fieldBaseType = " + fieldBaseType + ", fieldDefLen = " + fieldDefLen + ", fieldDefDecimal = " + fieldDefDecimal + "}";
    }
}
