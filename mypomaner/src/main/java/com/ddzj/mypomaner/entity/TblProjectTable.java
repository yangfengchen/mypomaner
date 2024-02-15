package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目表管理;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_PROJECT_TABLE")
public class TblProjectTable extends AbstractEntity  {

    private static final long serialVersionUID = 1L;

    private String prefixName;

    private String name;

    private Integer enabled;

    private String projectCode;
    private String znName;

    private String codeName;

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "TblProjectTable{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", prefixName = " + prefixName +
            ", name = " + name +
            ", enabled = " + enabled +
            ", projectCode = " + projectCode +
            ", znName = " + znName +
            ", codeName = " + codeName +
        "}";
    }

    /**
     * 获取
     *
     * @return znName
     */
    public String getZnName() {
        return this.znName;
    }

    /**
     * 设置
     *
     * @param znName
     */
    public void setZnName(String znName) {
        this.znName = znName;
    }

    /**
     * 获取
     *
     * @return codeName
     */
    public String getCodeName() {
        return this.codeName;
    }

    /**
     * 设置
     *
     * @param codeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
