package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目字段表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_PROJECT_FILED")
public class TblProjectFiled extends AbstractEntity  {

    private static final long serialVersionUID = 1L;

    private String filedCode;

    private String filedName;

    private Integer filedPrimary;

    private Integer filedNull;

    private Integer filedAuto;

    private String filedType;

    private String filedDataType;

    private String filedLen;

    private String filedDecimal;

    private String filedDec;

    private String filedDefaultVal;

    private String filedHtmlType;

    private String tableId;

    private Integer enabled;

    private String projectCode;

    public String getFiledCode() {
        return filedCode;
    }

    public void setFiledCode(String filedCode) {
        this.filedCode = filedCode;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public Integer getFiledPrimary() {
        return filedPrimary;
    }

    public void setFiledPrimary(Integer filedPrimary) {
        this.filedPrimary = filedPrimary;
    }

    public Integer getFiledNull() {
        return filedNull;
    }

    public void setFiledNull(Integer filedNull) {
        this.filedNull = filedNull;
    }

    public Integer getFiledAuto() {
        return filedAuto;
    }

    public void setFiledAuto(Integer filedAuto) {
        this.filedAuto = filedAuto;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public String getFiledDataType() {
        return filedDataType;
    }

    public void setFiledDataType(String filedDataType) {
        this.filedDataType = filedDataType;
    }

    public String getFiledLen() {
        return filedLen;
    }

    public void setFiledLen(String filedLen) {
        this.filedLen = filedLen;
    }

    public String getFiledDecimal() {
        return filedDecimal;
    }

    public void setFiledDecimal(String filedDecimal) {
        this.filedDecimal = filedDecimal;
    }

    public String getFiledDec() {
        return filedDec;
    }

    public void setFiledDec(String filedDec) {
        this.filedDec = filedDec;
    }

    public String getFiledDefaultVal() {
        return filedDefaultVal;
    }

    public void setFiledDefaultVal(String filedDefaultVal) {
        this.filedDefaultVal = filedDefaultVal;
    }

    public String getFiledHtmlType() {
        return filedHtmlType;
    }

    public void setFiledHtmlType(String filedHtmlType) {
        this.filedHtmlType = filedHtmlType;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return "TblProjectFiled{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", filedCode = " + filedCode +
            ", filedName = " + filedName +
            ", filedPrimary = " + filedPrimary +
            ", filedNull = " + filedNull +
            ", filedAuto = " + filedAuto +
            ", filedType = " + filedType +
            ", filedDataType = " + filedDataType +
            ", filedLen = " + filedLen +
            ", filedDecimal = " + filedDecimal +
            ", filedDec = " + filedDec +
            ", filedDefaultVal = " + filedDefaultVal +
            ", filedHtmlType = " + filedHtmlType +
            ", tableId = " + tableId +
            ", enabled = " + enabled +
            ", projectCode = " + projectCode +
        "}";
    }
}
