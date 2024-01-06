package com.ddzj.mypomaner.vo;

import java.util.List;

public class TreeVo {
    // id
    private String id;
    // 显示标题
    private String title;
    private String field;
    // 子项
    private List<TreeVo> children;


    /**
     * 获取 id
     *
     * @return id id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 显示标题
     *
     * @return title 显示标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 显示标题
     *
     * @param title 显示标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     *
     * @return field
     */
    public String getField() {
        return this.field;
    }

    /**
     * 设置
     *
     * @param field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 获取 子项
     *
     * @return children 子项
     */
    public List<TreeVo> getChildren() {
        return this.children;
    }

    /**
     * 设置 子项
     *
     * @param children 子项
     */
    public void setChildren(List<TreeVo> children) {
        this.children = children;
    }
}
