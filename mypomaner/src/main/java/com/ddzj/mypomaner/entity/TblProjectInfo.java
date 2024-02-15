package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目信息表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_PROJECT_INFO")
public class TblProjectInfo extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String projectName;

    private String projectCode;

    private String projectZnName;

    private String packageName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectZnName() {
        return projectZnName;
    }

    public void setProjectZnName(String projectZnName) {
        this.projectZnName = projectZnName;
    }



    @Override
    public String toString() {
        return "TblProjectInfo{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", projectName = " + projectName +
            ", projectCode = " + projectCode +
            ", projectZnName = " + projectZnName +
            ", packageName = " + packageName +
        "}";
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
}
