package com.ddzj.mypomaner.dto;

import java.io.Serializable;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:12
 * @Description:
 * @Version:1.0
 **/
public class PageSearchDto implements Serializable {
    // 当前页码
    private Long current;
    // 每页多少
    private Long pageSize;


    /**
     * 获取 当前页码
     *
     * @return current 当前页码
     */
    public Long getCurrent() {
        if(this.current == null){
            return 1L;
        }
        return this.current;
    }

    /**
     * 设置 当前页码
     *
     * @param current 当前页码
     */
    public void setCurrent(Long current) {
        this.current = current;
    }


    /**
     * 获取 每页多少
     *
     * @return pageSize 每页多少
     */
    public Long getPageSize() {
        if(pageSize == null){
            return 10L;
        }
        return this.pageSize;
    }

    /**
     * 设置 每页多少
     *
     * @param pageSize 每页多少
     */
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
