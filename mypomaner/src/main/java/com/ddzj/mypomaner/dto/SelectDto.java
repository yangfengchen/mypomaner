package com.ddzj.mypomaner.dto;

public class SelectDto {
    // 显示名称
    private String label;
    // 值
    private String value;

    public SelectDto(){}

    public SelectDto(String label, String value){
        this.label = label;
        this.value = value;
    }

    /**
     * 获取 显示名称
     *
     * @return label 显示名称
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * 设置 显示名称
     *
     * @param label 显示名称
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取 值
     *
     * @return value 值
     */
    public String getValue() {
        return this.value;
    }

    /**
     * 设置 值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }
}
