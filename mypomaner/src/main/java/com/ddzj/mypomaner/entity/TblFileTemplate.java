package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 字段模板表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_FILE_TEMPLATE")
public class TblFileTemplate extends AbstractEntity {

    private static final long serialVersionUID = 1L;


    private String fileCode;

    private String fileName;

    private Integer filePrimary;

    private Integer fileNull;

    private Integer fileAuto;

    private String fileType;

    private String fileDataType;

    private String fileLen;

    private String fileDecimal;

    private String fileDec;

    private String fileDefaultVal;

    private String fileHtmlType;

    private String tableId;

    private Integer enabled;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFilePrimary() {
        return filePrimary;
    }

    public void setFilePrimary(Integer filePrimary) {
        this.filePrimary = filePrimary;
    }

    public Integer getFileNull() {
        return fileNull;
    }

    public void setFileNull(Integer fileNull) {
        this.fileNull = fileNull;
    }

    public Integer getFileAuto() {
        return fileAuto;
    }

    public void setFileAuto(Integer fileAuto) {
        this.fileAuto = fileAuto;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileDataType() {
        return fileDataType;
    }

    public void setFileDataType(String fileDataType) {
        this.fileDataType = fileDataType;
    }

    public String getFileLen() {
        return fileLen;
    }

    public void setFileLen(String fileLen) {
        this.fileLen = fileLen;
    }

    public String getFileDecimal() {
        return fileDecimal;
    }

    public void setFileDecimal(String fileDecimal) {
        this.fileDecimal = fileDecimal;
    }

    public String getFileDec() {
        return fileDec;
    }

    public void setFileDec(String fileDec) {
        this.fileDec = fileDec;
    }

    public String getFileDefaultVal() {
        return fileDefaultVal;
    }

    public void setFileDefaultVal(String fileDefaultVal) {
        this.fileDefaultVal = fileDefaultVal;
    }

    public String getFileHtmlType() {
        return fileHtmlType;
    }

    public void setFileHtmlType(String fileHtmlType) {
        this.fileHtmlType = fileHtmlType;
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
            ", fileCode = " + fileCode +
            ", fileName = " + fileName +
            ", filePrimary = " + filePrimary +
            ", fileNull = " + fileNull +
            ", fileAuto = " + fileAuto +
            ", fileType = " + fileType +
            ", fileDataType = " + fileDataType +
            ", fileLen = " + fileLen +
            ", fileDecimal = " + fileDecimal +
            ", fileDec = " + fileDec +
            ", fileDefaultVal = " + fileDefaultVal +
            ", fileHtmlType = " + fileHtmlType +
            ", tableId = " + tableId +
            ", enabled = " + enabled +
        "}";
    }
}
