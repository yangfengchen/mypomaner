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

    private String projectCode;

    private String tableTemplateCode;

    private String databaseType;

    private String codeType;

    private String prefixNameRepice;

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
        "}";
    }
}
