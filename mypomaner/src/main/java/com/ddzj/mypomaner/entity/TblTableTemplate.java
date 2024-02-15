package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 表模板;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_TABLE_TEMPLATE")
public class TblTableTemplate extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String prefixName;

    private String name;

    private Boolean enabled;
    private String code;


    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "TblTableTemplate{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", prefixName = " + prefixName +
            ", name = " + name +
            ", enabled = " + enabled +
            ", code = " + code +
        "}";
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
}
