package com.ddzj.mypomaner.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:03
 * @Description:
 * @Version:1.0
 **/
public abstract class AbstractEntity implements Serializable {
    // 主键
    protected String id;

    // 租户号
    protected String tenantId;

    // 乐观锁
    protected Long revision;

    // 创建人id
    protected String createdBy;

    // 创建时间

    protected LocalDateTime createdTime;

    //修改人id
    protected String updatedBy;

    //修改时间
    protected LocalDateTime updatedTime;


    /**
     * 获取 主键
     *
     * @return id 主键
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 租户号
     *
     * @return tenantId 租户号
     */
    public String getTenantId() {
        return this.tenantId;
    }

    /**
     * 设置 租户号
     *
     * @param tenantId 租户号
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 获取 乐观锁
     *
     * @return revision 乐观锁
     */
    public Long getRevision() {
        return this.revision;
    }

    /**
     * 设置 乐观锁
     *
     * @param revision 乐观锁
     */
    public void setRevision(Long revision) {
        this.revision = revision;
    }

    /**
     * 获取 创建人id
     *
     * @return createdBy 创建人id
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * 设置 创建人id
     *
     * @param createdBy 创建人id
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取
     *
     * @return createdTime
     */
    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    /**
     * 设置
     *
     * @param createdTime
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 修改人id
     *
     * @return updatedBy 修改人id
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * 设置 修改人id
     *
     * @param updatedBy 修改人id
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取 修改时间
     *
     * @return updatedTime 修改时间
     */
    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    /**
     * 设置 修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
