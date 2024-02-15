package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 19:39
 * @Description:
 * @Version:1.0
 **/
public class ProjectTableSearchPageDto extends PageSearchDto {

    private String projectCode;
    private String name;
    private String znName;

    private String codeName;


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
