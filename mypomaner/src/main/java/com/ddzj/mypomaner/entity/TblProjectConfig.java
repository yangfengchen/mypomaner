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
@TableName("TBL_PROJECT_CONFIG")
public class TblProjectConfig extends AbstractEntity  {

    private static final long serialVersionUID = 1L;

    // 项目编码
    private String projectCode;
    // 模板编码
    private String tableTemplateCode;
    // 数据类型
    private String databaseType;
    // 代码类型
    private String codeType;
    // 前缀替换
    private String prefixNameRepice;
    // 字段转换
    private Boolean fileNameConvert;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getTableTemplateCode() {
        return tableTemplateCode;
    }

    public void setTableTemplateCode(String tableTemplateCode) {
        this.tableTemplateCode = tableTemplateCode;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getPrefixNameRepice() {
        return prefixNameRepice;
    }

    public void setPrefixNameRepice(String prefixNameRepice) {
        this.prefixNameRepice = prefixNameRepice;
    }

    public Boolean getFileNameConvert() {
        return fileNameConvert;
    }

    public void setFileNameConvert(Boolean fileNameConvert) {
        this.fileNameConvert = fileNameConvert;
    }

    @Override
    public String toString() {
        return "TblProjectConfig{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", projectCode = " + projectCode +
            ", tableTemplateCode = " + tableTemplateCode +
            ", databaseType = " + databaseType +
            ", codeType = " + codeType +
            ", prefixNameRepice = " + prefixNameRepice +
            ", fileNameConvert = " + fileNameConvert +
        "}";
    }
}
