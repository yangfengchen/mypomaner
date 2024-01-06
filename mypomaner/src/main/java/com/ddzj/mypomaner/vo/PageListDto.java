package com.ddzj.mypomaner.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 01:37
 * @Description:
 * @Version:1.0
 **/
public class PageListDto<T> implements Serializable {
    // 当前页码
    private Long current;
    // 每页多少
    private Long pageSize;
    // 数据总条数
    private Long totalCount;
    // 数据总页数
    private Long totalPage;
    // 数据
    private List<T> results;

    public PageListDto(){}

    public PageListDto(IPage t){
        this.current = t.getCurrent();
        this.pageSize = t.getSize();
        this.totalPage = t.getPages();
        this.totalCount = t.getTotal();
    }

    public PageListDto(PageListDto t){
        this.current = t.getCurrent();
        this.pageSize = t.getPageSize();
        this.totalPage = t.getTotalPage();
        this.totalCount = t.getTotalCount();
    }

    public PageListDto(Long current, Long pageSize, Long totalCount){
        this.current = current;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        double d = totalCount * 1.0;
        if(d%pageSize == 0){
            this.totalPage = ((long) (d / pageSize)) + 1;
        }else{
            this.totalPage = ((long) (d / pageSize)) + 2;
        }
    }

    public PageListDto(List<T> results){
        this.results = results;
    }

    public PageListDto(Long current, Long pageSize, Long totalPage, Long totalCount){
        this.current = current;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public PageListDto(Long current, Long pageSize, Long totalCount, Long totalPage, List<T> results){
        this.current = current;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.results = results;
    }

    /**
     * 获取 当前页码
     *
     * @return current 当前页码
     */
    public Long getCurrent() {
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

    /**
     * 获取 数据总条数
     *
     * @return totalCount 数据总条数
     */
    public Long getTotalCount() {
        return this.totalCount;
    }

    /**
     * 设置 数据总条数
     *
     * @param totalCount 数据总条数
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取 数据总页数
     *
     * @return totalPage 数据总页数
     */
    public Long getTotalPage() {
        return this.totalPage;
    }

    /**
     * 设置 数据总页数
     *
     * @param totalPage 数据总页数
     */
    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取 数据
     *
     * @return results 数据
     */
    public List<T> getResults() {
        return this.results;
    }

    /**
     * 设置 数据
     *
     * @param results 数据
     */
    public void setResults(List<T> results) {
        this.results = results;
    }
}
