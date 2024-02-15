package com.ddzj.mypomaner.vo;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 20:01
 * @Description:
 * @Version:1.0
 **/
public class ProjectTableListVo {
    private String id;
    private String name;

    private Boolean enabled;

    private String projectCode;
    private String znName;

    private String codeName;

    private String packageName;

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
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
}
