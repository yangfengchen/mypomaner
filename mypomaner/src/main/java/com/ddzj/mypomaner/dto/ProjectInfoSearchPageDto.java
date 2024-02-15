package com.ddzj.mypomaner.dto;

public class ProjectInfoSearchPageDto extends PageSearchDto {
    private String id;
    private String projectName;

    private String projectCode;

    private String projectZnName;


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
}
