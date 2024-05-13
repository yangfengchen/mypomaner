package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 15:22
 * @Description:
 * @Version:1.0
 **/
public class ProjectInfoSaveDto {
    private String id;
    private String projectName;

    private String projectCode;

    private String projectZnName;

    private String tableTemplateCode;

    private String databaseType;

    private String codeType;

    private String packageName;
    private Boolean fileNameConvert;


    /**
     * 获取
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return projectName
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * 设置
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取
     *
     * @return projectCode
     */
    public String getProjectCode() {
        return this.projectCode;
    }

    /**
     * 设置
     *
     * @param projectCode
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    /**
     * 获取
     *
     * @return projectZnName
     */
    public String getProjectZnName() {
        return this.projectZnName;
    }

    /**
     * 设置
     *
     * @param projectZnName
     */
    public void setProjectZnName(String projectZnName) {
        this.projectZnName = projectZnName;
    }

    /**
     * 获取
     *
     * @return tableTemplateCode
     */
    public String getTableTemplateCode() {
        return this.tableTemplateCode;
    }

    /**
     * 设置
     *
     * @param tableTemplateCode
     */
    public void setTableTemplateCode(String tableTemplateCode) {
        this.tableTemplateCode = tableTemplateCode;
    }

    /**
     * 获取
     *
     * @return databaseType
     */
    public String getDatabaseType() {
        return this.databaseType;
    }

    /**
     * 设置
     *
     * @param databaseType
     */
    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    /**
     * 获取
     *
     * @return codeType
     */
    public String getCodeType() {
        return this.codeType;
    }

    /**
     * 设置
     *
     * @param codeType
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
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
}
