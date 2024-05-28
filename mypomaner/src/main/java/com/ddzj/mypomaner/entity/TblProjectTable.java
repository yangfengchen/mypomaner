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

    // 表名前缀
    private String prefixName;
    // 表名
    private String name;
    // 是否启用
    private Boolean enabled;
    // 项目编码
    private String projectCode;
    // 表中文名称
    private String znName;
    // 表实体类名称
    private String codeName;
    // 包名称
    private String packageName;
    // 字段转换
    private Boolean fileNameConvert;
    // 索引名称
    private String indexName;
    // 创建人名称
    private String createName;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
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
            ", packageName = " + packageName +
            ", fileNameConvert = " + fileNameConvert +
            ", indexName = " + indexName +
            ", createName = " + createName +
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

    /**
     * 获取
     *
     * @return packageName
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * 设置
     *
     * @param packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Boolean getFileNameConvert() {
        return fileNameConvert;
    }

    public void setFileNameConvert(Boolean fileNameConvert) {
        this.fileNameConvert = fileNameConvert;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}
