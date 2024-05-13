package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 字段模板表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_FIELD_TEMPLATE")
public class TblFieldTemplate extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    // 数据库字段名称
    private String fieldCode;
    // 字段名称
    private String fieldName;
    // 字段是否是主键
    private Boolean fieldPrimary;
    // 字段是否为空
    private Boolean fieldNull;
    // 字段是否自增
    private Boolean fieldAuto;
    // 字段类型
    private String fieldType;
    // 字段数据库类型
    private String fieldDataType;
    // 字段长度
    private String fieldLen;
    // 字段小数位
    private String fieldDecimal;
    // 字段描述
    private String fieldDec;
    // 字段默认值
    private String fieldDefaultVal;
    // 字段html类型
    private String fieldHtmlType;
    // 表id
    private String tableId;
    // 是否启用
    private Boolean enabled;
    // 是否启用dto
    private Boolean fieldDtoStatus;
    // 是否启用vo
    private Boolean fieldVoStatus;

    @Override
    public String toString() {
        return "TblFileTemplate{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", fieldCode = " + fieldCode +
            ", fieldName = " + fieldName +
            ", fieldPrimary = " + fieldPrimary +
            ", fieldNull = " + fieldNull +
            ", fieldAuto = " + fieldAuto +
            ", fieldType = " + fieldType +
            ", fieldDataType = " + fieldDataType +
            ", fieldLen = " + fieldLen +
            ", fieldDecimal = " + fieldDecimal +
            ", fieldDec = " + fieldDec +
            ", fieldDefaultVal = " + fieldDefaultVal +
            ", fieldHtmlType = " + fieldHtmlType +
            ", tableId = " + tableId +
            ", enabled = " + enabled +
            ", fieldDtoStatus = " + fieldDtoStatus +
            ", fieldVoStatus = " + fieldVoStatus +
        "}";
    }


    /**
     * 获取
     *
     * @return fieldCode
     */
    public String getFieldCode() {
        return this.fieldCode;
    }

    /**
     * 设置
     *
     * @param fieldCode
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    /**
     * 获取
     *
     * @return fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * 设置
     *
     * @param fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取
     *
     * @return fieldPrimary
     */
    public Boolean getFieldPrimary() {
        return this.fieldPrimary;
    }

    /**
     * 设置
     *
     * @param fieldPrimary
     */
    public void setFieldPrimary(Boolean fieldPrimary) {
        this.fieldPrimary = fieldPrimary;
    }

    /**
     * 获取
     *
     * @return fieldNull
     */
    public Boolean getFieldNull() {
        return this.fieldNull;
    }

    /**
     * 设置
     *
     * @param fieldNull
     */
    public void setFieldNull(Boolean fieldNull) {
        this.fieldNull = fieldNull;
    }

    /**
     * 获取
     *
     * @return fieldAuto
     */
    public Boolean getFieldAuto() {
        return this.fieldAuto;
    }

    /**
     * 设置
     *
     * @param fieldAuto
     */
    public void setFieldAuto(Boolean fieldAuto) {
        this.fieldAuto = fieldAuto;
    }

    /**
     * 获取
     *
     * @return fieldType
     */
    public String getFieldType() {
        return this.fieldType;
    }

    /**
     * 设置
     *
     * @param fieldType
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * 获取
     *
     * @return fieldDataType
     */
    public String getFieldDataType() {
        return this.fieldDataType;
    }

    /**
     * 设置
     *
     * @param fieldDataType
     */
    public void setFieldDataType(String fieldDataType) {
        this.fieldDataType = fieldDataType;
    }

    /**
     * 获取
     *
     * @return fieldLen
     */
    public String getFieldLen() {
        return this.fieldLen;
    }

    /**
     * 设置
     *
     * @param fieldLen
     */
    public void setFieldLen(String fieldLen) {
        this.fieldLen = fieldLen;
    }

    /**
     * 获取
     *
     * @return fieldDecimal
     */
    public String getFieldDecimal() {
        return this.fieldDecimal;
    }

    /**
     * 设置
     *
     * @param fieldDecimal
     */
    public void setFieldDecimal(String fieldDecimal) {
        this.fieldDecimal = fieldDecimal;
    }

    /**
     * 获取
     *
     * @return fieldDec
     */
    public String getFieldDec() {
        return this.fieldDec;
    }

    /**
     * 设置
     *
     * @param fieldDec
     */
    public void setFieldDec(String fieldDec) {
        this.fieldDec = fieldDec;
    }

    /**
     * 获取
     *
     * @return fieldDefaultVal
     */
    public String getFieldDefaultVal() {
        return this.fieldDefaultVal;
    }

    /**
     * 设置
     *
     * @param fieldDefaultVal
     */
    public void setFieldDefaultVal(String fieldDefaultVal) {
        this.fieldDefaultVal = fieldDefaultVal;
    }

    /**
     * 获取
     *
     * @return fieldHtmlType
     */
    public String getFieldHtmlType() {
        return this.fieldHtmlType;
    }

    /**
     * 设置
     *
     * @param fieldHtmlType
     */
    public void setFieldHtmlType(String fieldHtmlType) {
        this.fieldHtmlType = fieldHtmlType;
    }

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

    /**
     * 获取
     *
     * @return fieldDtoStatus
     */
    public Boolean getFieldDtoStatus() {
        return this.fieldDtoStatus;
    }

    /**
     * 设置
     *
     * @param fieldDtoStatus
     */
    public void setFieldDtoStatus(Boolean fieldDtoStatus) {
        this.fieldDtoStatus = fieldDtoStatus;
    }

    /**
     * 获取
     *
     * @return fieldVoStatus
     */
    public Boolean getFieldVoStatus() {
        return this.fieldVoStatus;
    }

    /**
     * 设置
     *
     * @param fieldVoStatus
     */
    public void setFieldVoStatus(Boolean fieldVoStatus) {
        this.fieldVoStatus = fieldVoStatus;
    }
}
