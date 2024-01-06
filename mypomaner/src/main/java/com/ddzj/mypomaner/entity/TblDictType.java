package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_DICT_TYPE")
public class TblDictType extends AbstractEntity  {

    private static final long serialVersionUID = 1L;

    private String dictName;

    private String dictType;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    @Override
    public String toString() {
        return "TblDictType{" +
            "id = " + id +
            ", tenantId = " + tenantId +
            ", revision = " + revision +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updatedBy = " + updatedBy +
            ", updatedTime = " + updatedTime +
            ", dictName = " + dictName +
            ", dictType = " + dictType +
        "}";
    }
}
