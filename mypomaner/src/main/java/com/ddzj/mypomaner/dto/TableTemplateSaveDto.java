package com.ddzj.mypomaner.dto;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 11:57
 * @Description:
 * @Version:1.0
 **/
public class TableTemplateSaveDto {
    private String id;
    private String name;
    private String code;
    private Boolean enabled;

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
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
}
