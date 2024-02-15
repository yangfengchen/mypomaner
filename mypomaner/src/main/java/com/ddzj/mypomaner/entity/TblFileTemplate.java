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

    private Boolean filePrimary;

    private Boolean fileNull;

    private Boolean fileAuto;

    private String fileType;

    private String fileDataType;

    private String fileLen;

    private String fileDecimal;

    private String fileDec;

    private String fileDefaultVal;

    private String fileHtmlType;

    private String tableId;

    private Boolean enabled;

    private Boolean fileDtoStatus;

    private Boolean fileVoStatus;

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
            ", fileDtoStatus = " + fileDtoStatus +
            ", fileVoStatus = " + fileVoStatus +
        "}";
    }

    /**
     * 获取
     *
     * @return filePrimary
     */
    public Boolean getFilePrimary() {
        return this.filePrimary;
    }

    /**
     * 设置
     *
     * @param filePrimary
     */
    public void setFilePrimary(Boolean filePrimary) {
        this.filePrimary = filePrimary;
    }

    /**
     * 获取
     *
     * @return fileNull
     */
    public Boolean getFileNull() {
        return this.fileNull;
    }

    /**
     * 设置
     *
     * @param fileNull
     */
    public void setFileNull(Boolean fileNull) {
        this.fileNull = fileNull;
    }

    /**
     * 获取
     *
     * @return fileAuto
     */
    public Boolean getFileAuto() {
        return this.fileAuto;
    }

    /**
     * 设置
     *
     * @param fileAuto
     */
    public void setFileAuto(Boolean fileAuto) {
        this.fileAuto = fileAuto;
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
     * @return fileDtoStatus
     */
    public Boolean getFileDtoStatus() {
        return this.fileDtoStatus;
    }

    /**
     * 设置
     *
     * @param fileDtoStatus
     */
    public void setFileDtoStatus(Boolean fileDtoStatus) {
        this.fileDtoStatus = fileDtoStatus;
    }

    /**
     * 获取
     *
     * @return fileVoStatus
     */
    public Boolean getFileVoStatus() {
        return this.fileVoStatus;
    }

    /**
     * 设置
     *
     * @param fileVoStatus
     */
    public void setFileVoStatus(Boolean fileVoStatus) {
        this.fileVoStatus = fileVoStatus;
    }
}
